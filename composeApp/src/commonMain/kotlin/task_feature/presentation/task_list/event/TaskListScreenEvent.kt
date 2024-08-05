package task_feature.presentation.task_list.event

import task_feature.domain.TaskFilter

sealed interface TaskListScreenEvent {

    data object OnSearchedButtonClicked:TaskListScreenEvent
    data object OnAscendingButtonClicked:TaskListScreenEvent
    data object OnDescendingButtonClicked:TaskListScreenEvent
    data object OnFilterButtonChanged:TaskListScreenEvent


    data class OnFilterTypeChose(val filter:TaskFilter):TaskListScreenEvent
    data class OnSearchTextEntered(val text:String):TaskListScreenEvent


}