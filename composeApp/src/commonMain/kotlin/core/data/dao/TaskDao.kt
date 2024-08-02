package core.data.dao

import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import core.data.entity.Task
import kotlinx.coroutines.flow.Flow

interface TaskDao {

    @Query("SELECT * FROM Task")
    fun getAllTask():Flow<List<Task>>

    @Upsert
    fun upsertTask(task: Task)

    @Query("SELECT * FROM Task WHERE id =:id")
    fun getTaskById(id:Int):Task

    @Delete
    fun deleteTask(task: Task)

}