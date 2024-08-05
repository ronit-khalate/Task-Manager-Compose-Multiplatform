package task_feature.domain.repository

import task_feature.domain.TaskDto

interface TaskListRepository {

    suspend fun changeTaskStatus(taskDto: TaskDto)
    suspend fun editTask(taskDto: TaskDto)
    suspend fun deleteTask(taskDto: TaskDto)
}