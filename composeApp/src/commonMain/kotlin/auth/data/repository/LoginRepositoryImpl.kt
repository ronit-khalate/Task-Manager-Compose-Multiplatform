package auth.data.repository

import auth.domain.repository.LoginRepository
import auth.presentation.login.event.LoginScreenException
import core.data.database.Database

class LoginRepositoryImpl(
    private val database: Database
):LoginRepository {
    override suspend fun Login(email: String, password: String):Int {

        val user = database.userDao().gerUserByEmail(email)

        if(user==null){
            throw LoginScreenException.UserNotFound("User With $email Not Found")

        }

        if(user.password != password){
            throw LoginScreenException.InvalidEmailOrPasswordException("Invalid Email Or Password")
        }

        return  user.id

    }
}