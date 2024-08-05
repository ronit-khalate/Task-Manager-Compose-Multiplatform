package task_feature.presentation.task_list.state

import task_feature.domain.TaskFilter
import task_feature.domain.TaskOrder

data class TaskListScreenState(
    val searchedText:String ="",
    val order:TaskOrder = TaskOrder.ASCENDING,
    val filter:TaskFilter = TaskFilter.DATE
)
