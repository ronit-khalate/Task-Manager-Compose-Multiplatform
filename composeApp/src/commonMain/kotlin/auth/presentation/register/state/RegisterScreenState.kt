package auth.presentation.register.state

data class RegisterScreenState(
    val firstName:String="",
    val lastName:String="",
    val email:String="",
    val password:String="",
    val confirmPassword:String="",
    val showSnackBar:Boolean = false,
    val snackBarMessage:String="",
){

    fun isAnyPropertiesBlank():Boolean{

        return this.password.isBlank() && this.firstName.isBlank() && this.lastName.isBlank() && this.password.isBlank() && this.confirmPassword.isBlank()
    }
}