package task_feature.domain.repository

import task_feature.domain.TaskDto

interface TaskListRepository {

    fun changeTaskStatus(taskDto: TaskDto)
    fun editTask(taskDto: TaskDto)
    fun deleteTask(taskDto: TaskDto)
}