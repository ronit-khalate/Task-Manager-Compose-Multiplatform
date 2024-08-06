package core.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import core.data.entity.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM Task WHERE userId =:uId")
    fun getAllTask(uId:Int):Flow<List<Task>?>

    @Upsert
    suspend fun upsertTask(task: Task)

    @Query("SELECT * FROM Task WHERE id =:id")
    suspend fun getTaskById(id:Int):Task

    @Delete
    suspend fun deleteTask(task: Task)

}