package auth.domain

data class UserDto(
    val firstName:String,
    val lastName:String,
    val email:String,
    val password:String
)
