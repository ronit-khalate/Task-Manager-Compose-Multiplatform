package auth.presentation.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import auth.data.repository.RegistrationRepositoryImp
import auth.presentation.register.event.RegisterScreenEvent
import auth.presentation.register.event.RegistrationException
import auth.presentation.register.state.RegisterScreenState
import core.data.entity.User
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val registrationRepositoryImp: RegistrationRepositoryImp
):ViewModel() {


    var state by mutableStateOf(RegisterScreenState())
        private set

    val coroutineExceptionHandler = CoroutineExceptionHandler{ _, exception->
        when(exception){

            is RegistrationException.EmailAlreadyExistsException ->{
                state=state.copy(showSnackBar = true, snackBarMessage = exception.message.toString())

            }
        }

    }



    fun onEvent(event:RegisterScreenEvent){

        when(event){
            is RegisterScreenEvent.OnFirstNameEntered -> {
                state=state.copy(firstName = event.firstName)
            }

            is RegisterScreenEvent.OnLastNameEntered -> {
                state=state.copy(lastName = event.lastName)
            }

            is RegisterScreenEvent.OnEmailEntered -> {
               state= state.copy(email = event.email)
            }

            is RegisterScreenEvent.OnPasswordEntered -> {
                state=state.copy(password = event.password)
            }

            is RegisterScreenEvent.OnConfiremPasswordEntered -> {
                state=state.copy(confirmPassword = event.confirmPassword)
            }

            is RegisterScreenEvent.OnRegister -> {

                if(state.isAnyPropertiesBlank()){
                    state=state.copy(showSnackBar = true, snackBarMessage = "Details Should Not Be Empty")
                    return
                }

                if(state.password != state.confirmPassword){
                    state=state.copy(showSnackBar = true, snackBarMessage = "Both Password Should be Same")
                    return
                }




                val user = User(firstName = state.firstName, lastName = state.lastName, password = state.password, email = state.email)
                viewModelScope.launch(coroutineExceptionHandler){
                    registrationRepositoryImp.registerUser(user)
                }



            }

            is RegisterScreenEvent.RestSnackBarState -> {
                state=state.copy(showSnackBar = false, snackBarMessage = "")

            }
        }
    }
}