package auth.presentation.register.event

sealed interface RegisterScreenEvent {

    data class OnFirstNameEntered(val firstName:String):RegisterScreenEvent
    data class OnLastNameEntered(val lastName:String):RegisterScreenEvent
    data class OnEmailEntered(val email:String):RegisterScreenEvent
    data class OnPasswordEntered(val password:String):RegisterScreenEvent
    data class OnConfiremPasswordEntered(val confirmPassword:String):RegisterScreenEvent
    data object OnRegister:RegisterScreenEvent
    data object RestSnackBarState:RegisterScreenEvent


}

