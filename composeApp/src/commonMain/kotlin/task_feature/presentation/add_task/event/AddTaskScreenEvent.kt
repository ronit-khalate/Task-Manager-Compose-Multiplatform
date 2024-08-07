package task_feature.presentation.add_task.event

import kotlinx.datetime.LocalDate

sealed interface AddTaskScreenEvent {

    data class OnTitleEntered(val title:String):AddTaskScreenEvent
    data class OnDescriptionEntered(val description:String):AddTaskScreenEvent

    data class OnDueDateSelected(val localDate: LocalDate):AddTaskScreenEvent

    data object OnStatusButtonClicked:AddTaskScreenEvent

    data object OnAddTask:AddTaskScreenEvent
}