package auth.data.repository

import auth.domain.UserDto
import auth.domain.repository.RegistrationRepository
import auth.presentation.register.event.RegistrationException
import core.data.entity.User
import core.data.database.*
import core.data.mapper.toUserDto

class RegistrationRepositoryImp(
    private val database: Database
):RegistrationRepository {

    override suspend fun registerUser(user: User):UserDto {


        val isUserAlreadyExits= database.userDao().gerUserByEmail(user.email) != null
        if(isUserAlreadyExits){
            throw RegistrationException.EmailAlreadyExistsException("${user.email} Already Exits")
        }
        else{

            database.userDao().registerUser(user)

            return database.userDao().gerUserByEmail(user.email)!!.toUserDto()
        }

    }
}