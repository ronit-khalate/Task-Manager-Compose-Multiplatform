package auth.domain.repository

import auth.domain.UserDto

interface LoginRepository {

    suspend fun Login(email:String,password:String): UserDto
}