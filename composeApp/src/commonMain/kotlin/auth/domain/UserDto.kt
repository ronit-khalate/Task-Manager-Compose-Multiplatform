package auth.domain

data class UserDto(
    val id:Int,
    val name:String,
    val email:String,
    val password:String
)
