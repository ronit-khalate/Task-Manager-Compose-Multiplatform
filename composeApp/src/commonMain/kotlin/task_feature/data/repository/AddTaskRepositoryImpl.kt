package task_feature.data.repository

import core.data.database.Database
import core.data.mapper.toTask
import task_feature.domain.TaskDto
import task_feature.domain.repository.AddTaskRepository

class AddTaskRepositoryImpl(
    val database: Database
):AddTaskRepository {
    override suspend fun addTask(task: TaskDto) {

        database.taskDao().upsertTask(task=task.toTask())
    }
}