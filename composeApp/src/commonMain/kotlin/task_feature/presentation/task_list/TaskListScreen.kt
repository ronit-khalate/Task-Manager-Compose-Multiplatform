package task_feature.presentation.task_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.safeGesturesPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import core.navigation.Screen
import task_feature.presentation.components.TaskComposable
import task_feature.presentation.components.TaskListTopBar
import task_feature.presentation.task_list.event.TaskListScreenEvent

@Composable
fun TaskListScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: TaskListScreenViewModel,
    platform:Int=1,
    floatingActionButton: (@Composable ()-> Unit)? = null,


) {

    var showCompletedTasks by remember { mutableStateOf(true) }

    val listInnerPadding = 24.dp



    Scaffold(
        modifier = modifier
            .background(Color(0xFF27323A))
            .safeDrawingPadding()
            .padding(top = listInnerPadding),

        topBar = {

            TaskListTopBar(
                    innerPadding = listInnerPadding,
                    onAscendingButtonClicked = {viewModel.onEvent(TaskListScreenEvent.OnAscendingButtonClicked)},
                    onDescendingButtonClicked = {viewModel.onEvent(TaskListScreenEvent.OnDescendingButtonClicked)},
                    onLogOut = { enableLogOutButton ->
                        viewModel.onEvent(
                            TaskListScreenEvent.OnLogOut{

                                enableLogOutButton()
                                navController.navigate(Screen.FlashScreen.route){
                                    popUpTo(Screen.FlashScreen.route){
                                        inclusive=true
                                    }
                                }
                            }
                        )
                    },
                    onSearchTextEntered = {viewModel.onEvent(TaskListScreenEvent.OnSearchTextEntered(it))}
            )
        },
        backgroundColor = Color(0xFF27323A),
        floatingActionButton = {

           floatingActionButton?.invoke()

        }
    ){

        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = listInnerPadding, end = listInnerPadding),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,

        ){
            items(
                items = viewModel.inCompetedTask,
                key = { it.id!! }
            ){

                    TaskComposable(
                            task = it,
                            onStatusClicked = { viewModel.onEvent(TaskListScreenEvent.OnTaskStatusChanged(it)) },
                            onDelete = { viewModel.onEvent(TaskListScreenEvent.OnDeleteTask(it)) },
                            onTitleChanged = { title -> viewModel.onEvent(TaskListScreenEvent.OnEditTask(it.copy(title = title)))},
                            onDescriptionChanged = { description -> viewModel.onEvent(TaskListScreenEvent.OnEditTask(it.copy(description = description)))},
                            platform = platform
                    )


            }

            item {
                Spacer(Modifier.height(30.dp))

                Row(
                    modifier = Modifier
                        .height(60.dp)
                        .padding(start = 10.dp, end = 10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween

                ){
                    Text(
                        text = "Completed",
                        fontSize = 20.sp,
                        fontWeight = FontWeight(700),
                        color = Color.LightGray
                    )

                    IconButton(
                        onClick = {
                            showCompletedTasks = !showCompletedTasks
                        }
                    ) {

                        Image(
                            modifier = Modifier
                                .size(30.dp),
                            imageVector = if(showCompletedTasks)Icons.Filled.KeyboardArrowDown else Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            colorFilter = ColorFilter.tint(Color.Gray),
                            contentDescription = null
                        )
                    }
                }
            }


            if(showCompletedTasks) {



                items(
                    items = viewModel.competedTask,
                    key = {it.id!!}
                ){

                    TaskComposable(
                        task = it,
                        onStatusClicked = { viewModel.onEvent(TaskListScreenEvent.OnTaskStatusChanged(it)) },
                        onDelete = {viewModel.onEvent(TaskListScreenEvent.OnDeleteTask(it))},
                        onTitleChanged = {

                            title -> viewModel.onEvent(TaskListScreenEvent.OnTitleEdit(it.copy(title = title)))
                        },
                        onDescriptionChanged = {
                            description -> viewModel.onEvent(TaskListScreenEvent.OnDescriptionEdit(it.copy(description = description)))
                        },
                        platform = platform
                    )
                }

                item { Spacer(modifier = Modifier.height(60.dp + 10.dp))}
            }


        }


    }
}