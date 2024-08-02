package core.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import core.data.entity.User

@Dao
interface UserDao {

    // For login
    @Query("SELECT * FROM User WHERE email = :email")
    fun gerUserByEmail(email:String): User

    // For registering
    @Upsert
    fun registerUser(user: User)


}