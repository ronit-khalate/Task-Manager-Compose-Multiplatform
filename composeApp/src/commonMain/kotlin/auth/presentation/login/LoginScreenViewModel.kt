package auth.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import auth.data.repository.LoginRepositoryImpl
import auth.presentation.login.event.LoginScreenEvent
import auth.presentation.login.event.LoginScreenException
import auth.presentation.login.state.LoginScreenState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class LoginScreenViewModel(
    private val repository: LoginRepositoryImpl
):ViewModel() {

    var state by mutableStateOf(LoginScreenState())

    val handler = CoroutineExceptionHandler { coroutineContext, throwable ->

        when(throwable){

            is LoginScreenException.UserNotFound ->{
                state=state.copy(showSnackBar = true , snackBarMessage = throwable.message.toString())
            }

            is LoginScreenException.InvalidEmailOrPasswordException ->{

                state=state.copy(showSnackBar = true , snackBarMessage = throwable.message.toString())
            }
        }
    }


    fun onEvent(event: LoginScreenEvent){

        when(event){
            is LoginScreenEvent.OnEmailEntered -> {

                state=state.copy(email = event.email)
            }
            is LoginScreenEvent.OnPasswordEntered ->{

                state=state.copy(password = event.password)
            }
            is LoginScreenEvent.OnSignIn -> {

                viewModelScope.launch(handler) {
                    repository.Login(email = state.email, password = state.password)
                }

            }

            LoginScreenEvent.RestSnackBarState -> {

                state =state.copy(showSnackBar = false, snackBarMessage = "")
            }
        }
    }
}