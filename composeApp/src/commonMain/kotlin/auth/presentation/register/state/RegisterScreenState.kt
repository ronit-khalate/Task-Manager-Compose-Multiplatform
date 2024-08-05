package auth.presentation.register.state

data class RegisterScreenState(
    val name:String="",
    val email:String="",
    val password:String="",
    val confirmPassword:String="",
    val showSnackBar:Boolean = false,
    val snackBarMessage:String="",
){

    fun isAnyPropertiesBlank():Boolean{

        return (this.password.isBlank() || this.name.isBlank() || this.password.isBlank() || this.confirmPassword.isBlank())
    }
}