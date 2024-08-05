package auth.presentation.login.state

data class LoginScreenState(
    val email:String="",
    val password:String="",
    val showSnackBar:Boolean=false,
    val snackBarMessage:String=""
)
