import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import task_feature.presentation.add_task.AddTaskScreen
import task_feature.presentation.add_task.AddTaskViewModel
import task_feature.presentation.task_list.TaskListScreen
import task_feature.presentation.task_list.TaskListScreenViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    taskListScreenViewModel: TaskListScreenViewModel,
    addTaskViewModel: AddTaskViewModel
) {

    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF27323A))
    ){





        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.40f)
        ) {
            TaskListScreen(
                modifier = Modifier,
                navController=navController,
                viewModel = taskListScreenViewModel,
                platform = 0
            )
        }

        Spacer(modifier = Modifier.width(100.dp))
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.40f)
        ){


            AddTaskScreen(
                modifier = Modifier,
                navController=navController,
                viewModel = addTaskViewModel,
                platform = 0
            )

        }



    }

}