package auth.data.repository

import auth.domain.UserDto
import auth.domain.repository.LoginRepository
import auth.presentation.login.event.LoginScreenException
import core.data.database.Database
import core.data.mapper.toUserDto

class LoginRepositoryImpl(
    private val database: Database
):LoginRepository {
    override suspend fun Login(email: String, password: String):UserDto {

        val user = database.userDao().gerUserByEmail(email)

        if(user==null){
            throw LoginScreenException.UserNotFound("User With $email Not Found")

        }

        if(user.password != password){
            throw LoginScreenException.InvalidEmailOrPasswordException("Invalid Email Or Password")
        }

        return  user.toUserDto()

    }
}