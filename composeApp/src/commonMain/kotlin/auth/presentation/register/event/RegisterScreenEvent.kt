package auth.presentation.register.event

sealed interface RegisterScreenEvent {

    data class OnNameEntered(val name:String):RegisterScreenEvent
    data class OnEmailEntered(val email:String):RegisterScreenEvent
    data class OnPasswordEntered(val password:String):RegisterScreenEvent
    data class OnConfiremPasswordEntered(val confirmPassword:String):RegisterScreenEvent
    data class OnRegister(val onSuccess:(userId:Int)->Unit):RegisterScreenEvent
    data object RestSnackBarState:RegisterScreenEvent


}

