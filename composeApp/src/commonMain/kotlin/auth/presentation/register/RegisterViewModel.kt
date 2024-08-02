package auth.presentation.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import auth.presentation.register.event.RegisterScreenEvent
import auth.presentation.register.state.RegisterScreenState

class RegisterViewModel():ViewModel() {


    var state by mutableStateOf(RegisterScreenState())
        private set



    fun onEvent(event:RegisterScreenEvent){

        state = when(event){
            is RegisterScreenEvent.onFirstNameEntered -> {
                state.copy(firstName = event.firstName)
            }

            is RegisterScreenEvent.onLastNameEntered -> {
                state.copy(lastName = event.lastName)
            }

            is RegisterScreenEvent.onEmailEntered -> {
                state.copy(email = event.email)
            }

            is RegisterScreenEvent.onPasswordEntered -> {
                state.copy(password = event.password)
            }

            is RegisterScreenEvent.onConfiremPasswordEntered -> {
                state.copy(confirmPassword = event.confirmPassword)
            }

            is RegisterScreenEvent.onRegister -> TODO()
        }
    }
}