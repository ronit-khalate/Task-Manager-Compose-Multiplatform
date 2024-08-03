package auth.domain.repository

import core.data.entity.User

interface RegistrationRepository {

    suspend fun registerUser(user: User)
}