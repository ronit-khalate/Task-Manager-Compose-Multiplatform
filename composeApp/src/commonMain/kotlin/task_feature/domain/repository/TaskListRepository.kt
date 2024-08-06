package task_feature.domain.repository

import core.data.entity.UserWithTask
import kotlinx.coroutines.flow.Flow
import task_feature.domain.TaskDto
import task_feature.domain.UserWithTasksDto

interface TaskListRepository {

    suspend fun changeTaskStatus(taskDto: TaskDto)
    suspend fun editTask(taskDto: TaskDto)
    suspend fun deleteTask(taskDto: TaskDto)
    suspend fun getUserWithTasks(userId:Int): Flow<UserWithTask?>
    suspend fun getAllTask(userId: Int):Flow<List<TaskDto>?>
}