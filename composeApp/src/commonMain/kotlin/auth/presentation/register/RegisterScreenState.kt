package auth.presentation.register

data class RegisterScreenState(
    val firstName:String="",
    val lastName:String="",
    val email:String="",
    val password:String="",
    val confirmPassword:String="",
)
