package task_feature.presentation.add_task.state

data class AddTaskScreenState(
    val title:String="",
    val description:String="",
    val dueDate:String="",
    val status:Boolean =false
)
