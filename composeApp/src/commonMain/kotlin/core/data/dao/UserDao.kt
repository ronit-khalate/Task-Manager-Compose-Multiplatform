package core.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import core.data.entity.User
import core.data.entity.UserWithTask

import javax.annotation.processing.Generated
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    // For login
    @Query("SELECT * FROM User WHERE email = :email")
    suspend fun gerUserByEmail(email:String): User?

    // For registering
    @Upsert
    suspend fun registerUser(user: User)

    @Transaction
    @Query("SELECT * FROM User WHERE id = :userId")
    fun getUserWithTask(userId:Int): Flow<UserWithTask?>


}