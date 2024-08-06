package task_feature.domain.repository

import task_feature.domain.TaskDto

interface AddTaskRepository {

    suspend fun addTask(task:TaskDto)
}