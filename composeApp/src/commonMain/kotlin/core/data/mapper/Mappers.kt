package core.data.mapper

import auth.domain.UserDto
import core.data.entity.User


fun User.toUserDto():UserDto = UserDto(

    name = this.name,
    email = this.email,
    password = this.password
)

fun UserDto.toUser():User = User(
    name = this.name,
    email = this.email,
    password = this.password
)