package task_feature.presentation.task_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import core.data.repository.DataStoreRepositoryImpl
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import task_feature.domain.TaskDto
import task_feature.domain.TaskFilter
import task_feature.domain.repository.TaskListRepository
import task_feature.presentation.task_list.event.TaskListScreenEvent
import task_feature.presentation.task_list.state.TaskListScreenState
import kotlin.properties.Delegates

class TaskListScreenViewModel(
    private val repository: TaskListRepository,
    private val dataStoreRepositoryImpl: DataStoreRepositoryImpl
):ViewModel() {


    var userId =0

    var state by mutableStateOf(TaskListScreenState())
        private set
    var tasks = mutableStateListOf<TaskDto>()

    var competedTask by mutableStateOf<List<TaskDto>>(emptyList())
    var inCompetedTask by mutableStateOf<List<TaskDto>>(emptyList())

    init {

        viewModelScope.launch {

            dataStoreRepositoryImpl.getLoggedInUserId().collect{ id->
                userId = id!!

                repository.getAllTask(userId).collect { it ->

                    it?.let {
                        tasks.clear()
                       tasks.addAll(it)

                        competedTask=tasks.filter { it.status }
                        inCompetedTask=tasks.filter { !it.status }
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


                val sorted=tasks.sortedBy {
                    if(state.filter == TaskFilter.TITLE){
                        it.title
                    }
                    else{

                        it.dueDate
                    }
                }
                tasks.clear()
                tasks.addAll(sorted)
                competedTask=tasks.filter { it.status }
                inCompetedTask=tasks.filter { !it.status }

            }
            is TaskListScreenEvent.OnDescendingButtonClicked -> {

                val sorted=tasks.sortedByDescending {
                    if(state.filter == TaskFilter.TITLE){
                        it.title
                    }
                    else{

                        it.dueDate
                    }
                }

                tasks.clear()
                tasks.addAll(sorted)
                competedTask=tasks.filter { it.status }
                inCompetedTask=tasks.filter { !it.status }
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
                    delay(800)
                    repository.changeTaskStatus(event.taskDto.copy(status = !event.taskDto.status))

                }
            }

            is TaskListScreenEvent.OnDeleteTask -> {

                viewModelScope.launch {
                    delay(800)
                    repository.deleteTask(taskDto = event.task )
                }

            }

            is TaskListScreenEvent.OnEditTask ->{

                viewModelScope.launch {

                    repository.editTask(event.task)

                }
            }

            is TaskListScreenEvent.OnDescriptionEdit -> {

                var idx :Int? = null
                var ts:TaskDto?=null

                tasks.forEachIndexed { index, taskDto ->

                    if (event.task.id==taskDto.id){
                        idx=index
                        ts=taskDto
                    }
                }


                ts?.let {

                    tasks[idx!!]= it.copy(description = event.task.description)
                }


            }
            is TaskListScreenEvent.OnTitleEdit -> {

                var idx :Int? = null
                var ts:TaskDto?=null

                tasks.mapIndexed() { index, taskDto ->

                    if (event.task.id==taskDto.id){
                        idx=index
                        ts=taskDto
                    }
                }



                ts?.let {

                    tasks[idx!!]= it.copy(title = event.task.title)
                }
            }

            is TaskListScreenEvent.OnLogOut -> {

                viewModelScope.launch {
                    dataStoreRepositoryImpl.removeLoggedInUser()
                    event.onSuccess()

                }
            }
        }
    }
}


