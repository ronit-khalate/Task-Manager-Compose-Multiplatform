package auth.presentation.register.event

sealed class RegistrationException(message: String) : Exception(message) {

    class EmailAlreadyExistsException(message: String) : RegistrationException(message)
    class PasswordMismatchException(message: String) : RegistrationException(message)
}
