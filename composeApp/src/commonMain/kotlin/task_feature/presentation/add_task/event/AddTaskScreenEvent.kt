package task_feature.presentation.add_task.event

sealed interface AddTaskScreenEvent {

    data class OnTitleEntered(val title:String):AddTaskScreenEvent
    data class OnDescriptionEntered(val description:String):AddTaskScreenEvent

    data object OnStatusButtonClicked:AddTaskScreenEvent

    data object OnAddTask:AddTaskScreenEvent
}