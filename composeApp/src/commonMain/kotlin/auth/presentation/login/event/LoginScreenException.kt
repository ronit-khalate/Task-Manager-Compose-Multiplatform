package auth.presentation.login.event

sealed class LoginScreenException(message: String): Exception(message) {

    class InvalidEmailOrPasswordException(message: String):LoginScreenException(message)
    class UserNotFound(message: String):LoginScreenException(message)
}