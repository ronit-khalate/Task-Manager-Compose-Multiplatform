package task_feature.presentation.task_list.event

import task_feature.domain.TaskDto
import task_feature.domain.TaskFilter

sealed interface TaskListScreenEvent {

    data object OnSearchedButtonClicked:TaskListScreenEvent
    data object OnAscendingButtonClicked:TaskListScreenEvent
    data object OnDescendingButtonClicked:TaskListScreenEvent
    data object OnFilterButtonClicked:TaskListScreenEvent
    data class OnLogOut(val onSuccess:()->Unit) : TaskListScreenEvent


    data class OnFilterTypeChose(val filter:TaskFilter):TaskListScreenEvent
    data class OnSearchTextEntered(val text:String):TaskListScreenEvent

    data class OnTaskStatusChanged(val taskDto: TaskDto):TaskListScreenEvent

    data class OnDeleteTask(val task:TaskDto):TaskListScreenEvent

    data class OnEditTask(val task: TaskDto):TaskListScreenEvent
    data class OnTitleEdit(val task: TaskDto):TaskListScreenEvent
    data class OnDescriptionEdit(val task: TaskDto):TaskListScreenEvent

}