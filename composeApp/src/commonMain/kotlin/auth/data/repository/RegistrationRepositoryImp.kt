package auth.data.repository

import auth.domain.repository.RegistrationRepository
import auth.presentation.register.event.RegistrationException
import core.data.entity.User
import core.data.database.*
class RegistrationRepositoryImp(
    private val database: Database
):RegistrationRepository {

    override suspend fun registerUser(user: User) {


        val isUserAlreadyExits= database.userDao().gerUserByEmail(user.email) != null
        if(isUserAlreadyExits){
            throw RegistrationException.EmailAlreadyExistsException("${user.email} Already Exits")


        }
        else{

            database.userDao().registerUser(user)
        }

    }
}