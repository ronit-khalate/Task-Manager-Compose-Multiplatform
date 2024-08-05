package auth.presentation.login.event

sealed interface LoginScreenEvent {

    data class OnEmailEntered(val email: String) : LoginScreenEvent

    data class OnPasswordEntered(val password: String) : LoginScreenEvent

    data object OnSignIn : LoginScreenEvent
    data object RestSnackBarState : LoginScreenEvent
}