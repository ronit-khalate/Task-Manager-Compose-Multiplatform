package core.data.mapper

import auth.domain.UserDto
import core.data.entity.User


fun User.toUserDto():UserDto = UserDto(

    firstName = this.firstName,
    lastName = this.lastName,
    email = this.email,
    password = this.password
)

fun UserDto.toUser():User = User(
    firstName = this.firstName,
    lastName = this.lastName,
    email = this.email,
    password = this.password
)