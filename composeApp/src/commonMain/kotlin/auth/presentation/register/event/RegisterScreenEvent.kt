package auth.presentation.register.event

sealed interface RegisterScreenEvent {

    data class OnNameEntered(val name:String):RegisterScreenEvent
    data class OnEmailEntered(val email:String):RegisterScreenEvent
    data class OnPasswordEntered(val password:String):RegisterScreenEvent
    data class OnConfiremPasswordEntered(val confirmPassword:String):RegisterScreenEvent
    data object OnRegister:RegisterScreenEvent
    data object RestSnackBarState:RegisterScreenEvent


}

