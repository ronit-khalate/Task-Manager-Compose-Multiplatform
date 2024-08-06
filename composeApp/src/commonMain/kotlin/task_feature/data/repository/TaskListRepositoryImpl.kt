package task_feature.data.repository

import core.data.database.Database
import core.data.entity.UserWithTask
import core.data.mapper.toTask
import core.data.mapper.toTaskDto
import core.data.mapper.toUserWithTasksDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import task_feature.domain.TaskDto
import task_feature.domain.UserWithTasksDto
import task_feature.domain.repository.TaskListRepository

class TaskListRepositoryImpl(
    private val database: Database
): TaskListRepository {
    override suspend fun changeTaskStatus(taskDto: TaskDto) {
       database.taskDao().upsertTask(taskDto.toTask())
    }

    override suspend fun editTask(taskDto: TaskDto) {
        database.taskDao().upsertTask(taskDto.toTask())
    }

    override suspend fun deleteTask(taskDto: TaskDto) {
        database.taskDao().deleteTask(taskDto.toTask())
    }

    override suspend fun getUserWithTasks(userId: Int): Flow<UserWithTask?> {

        return database.userDao().getUserWithTask(userId = userId)
    }

    override suspend fun getAllTask(userId: Int): Flow<List<TaskDto>?> {

        return database.taskDao().getAllTask(userId).map { it?.map { task -> task.toTaskDto() } }
    }


}