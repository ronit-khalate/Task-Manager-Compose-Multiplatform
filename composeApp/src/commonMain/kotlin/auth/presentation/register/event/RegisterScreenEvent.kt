package auth.presentation.register.event

sealed interface RegisterScreenEvent {

    data class onFirstNameEntered(val firstName:String):RegisterScreenEvent
    data class onLastNameEntered(val lastName:String):RegisterScreenEvent
    data class onEmailEntered(val email:String):RegisterScreenEvent
    data class onPasswordEntered(val password:String):RegisterScreenEvent
    data class onConfiremPasswordEntered(val confirmPassword:String):RegisterScreenEvent


}

