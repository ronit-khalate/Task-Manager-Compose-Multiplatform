package task_feature.presentation.task_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import core.data.repository.DataStoreRepositoryImpl
import kotlinx.coroutines.launch
import task_feature.domain.TaskDto
import task_feature.domain.TaskFilter
import task_feature.domain.repository.TaskListRepository
import task_feature.presentation.task_list.event.TaskListScreenEvent
import task_feature.presentation.task_list.state.TaskListScreenState
import kotlin.properties.Delegates

class TaskListScreenViewModel(
    var userId:Int,
    private val repository: TaskListRepository,
    private val dataStoreRepositoryImpl: DataStoreRepositoryImpl
):ViewModel() {

    var state by mutableStateOf(TaskListScreenState())
        private set
    var tasks = mutableStateListOf<TaskDto>()

    init {

        viewModelScope.launch {

            dataStoreRepositoryImpl.getLoggedInUserId().collect{ id->
                userId = id!!

                repository.getAllTask(userId).collect { it ->

                    it?.let {
                        tasks.clear()
                       tasks.addAll(it)
                    }


                }
                return@collect
            }




        }

    }


    init {

        viewModelScope.launch {

            repository.getAllTask(userId).collect{ lis->



            }

        }

    }



    fun onEvent(event: TaskListScreenEvent){

        when(event){
            is TaskListScreenEvent.OnAscendingButtonClicked -> {

                tasks.clear()
                val sorted=tasks.sortedBy {
                    if(state.filter == TaskFilter.TITLE){
                        it.title
                    }
                    else{

                        it.dueDate
                    }
                }

                tasks.addAll(sorted)
            }
            is TaskListScreenEvent.OnDescendingButtonClicked -> {
                tasks.clear()
                val sorted=tasks.sortedByDescending {
                    if(state.filter == TaskFilter.TITLE){
                        it.title
                    }
                    else{

                        it.dueDate
                    }
                }

                tasks.addAll(sorted)
            }
            is TaskListScreenEvent.OnFilterButtonClicked -> TODO()
            is TaskListScreenEvent.OnFilterTypeChose -> {
                state = state.copy(
                    filter = event.filter,
                )

            }
            is TaskListScreenEvent.OnSearchTextEntered -> TODO()
            is TaskListScreenEvent.OnSearchedButtonClicked -> TODO()

            is TaskListScreenEvent.OnTaskStatusChanged -> {

                viewModelScope.launch {
                    repository.changeTaskStatus(event.taskDto.copy(status = !event.taskDto.status))

                }
            }
        }
    }
}


