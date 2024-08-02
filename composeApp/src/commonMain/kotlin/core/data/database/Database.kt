package core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import core.data.dao.TaskDao
import core.data.dao.UserDao
import core.data.entity.Task
import core.data.entity.User

@Database(
    entities = [User::class, Task::class],
    version = 1

)
abstract class Database:RoomDatabase(){

    abstract fun taskDao():TaskDao
    abstract fun userDao():UserDao
}