package auth.domain.repository

import auth.domain.UserDto
import core.data.entity.User

interface RegistrationRepository {

    suspend fun registerUser(user: User): UserDto
}