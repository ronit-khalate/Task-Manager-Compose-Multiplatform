package task_feature.presentation.add_task

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import core.data.repository.DataStoreRepositoryImpl
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import task_feature.domain.TaskDto
import task_feature.domain.repository.AddTaskRepository
import task_feature.presentation.add_task.event.AddTaskScreenEvent
import task_feature.presentation.add_task.state.AddTaskScreenState
import kotlin.properties.Delegates

class AddTaskViewModel(

    private val repository: AddTaskRepository,
    private val dataStoreRepositoryImpl: DataStoreRepositoryImpl,

):ViewModel() {

    lateinit var job:Job
    var userId:Int? =0

    init {

        job=viewModelScope.launch {

            dataStoreRepositoryImpl.getLoggedInUserId().collect{
                userId = it
            }
        }

    }


    var state by mutableStateOf(AddTaskScreenState())
        private set


    private fun reset(){
        state = AddTaskScreenState()
    }




    fun onEvent(event:AddTaskScreenEvent){

        when(event){
            is AddTaskScreenEvent.OnAddTask -> {
                viewModelScope.launch {


                    val task = TaskDto(
                        userId = userId!!,
                        title = state.title,
                        description = state.description,
                        dueDate = state.dueDate,
                        status = state.status
                    )


                    repository.addTask(task = task)

                    job.cancel()

                    reset()




                }
            }
            is AddTaskScreenEvent.OnDescriptionEntered -> {
                state = state.copy(description = event.description)
            }
            is AddTaskScreenEvent.OnTitleEntered -> {
                state = state.copy(title = event.title)
            }

            is AddTaskScreenEvent.OnStatusButtonClicked -> {
                state=state.copy(status = !state.status)
            }

            is AddTaskScreenEvent.OnDueDateSelected -> {
                state=state.copy(
                    dueDate = "${event.localDate.dayOfMonth} ${event.localDate.month} ${event.localDate.year}"
                )
            }
        }
    }
}