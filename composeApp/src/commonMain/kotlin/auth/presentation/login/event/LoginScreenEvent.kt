package auth.presentation.login.event

sealed interface LoginScreenEvent {

    data class OnEmailEntered(val email: String) : LoginScreenEvent

    data class OnPasswordEntered(val password: String) : LoginScreenEvent

    data class OnSignIn(
        val onSignInSuccess:()->Unit,
        val onSignInFail:()->Unit,
    ): LoginScreenEvent
    data object RestSnackBarState : LoginScreenEvent

    data class ShowSnackBar(val message:String):LoginScreenEvent
}