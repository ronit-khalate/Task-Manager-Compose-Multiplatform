package core.domain.repository

import auth.domain.UserDto
import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {

    suspend fun saveLoggedInUser(userDto: UserDto):Boolean
    suspend fun removeLoggedInUser(userDto: UserDto):Boolean

    suspend fun getLoggedInUserId(): Flow<Int?>
}