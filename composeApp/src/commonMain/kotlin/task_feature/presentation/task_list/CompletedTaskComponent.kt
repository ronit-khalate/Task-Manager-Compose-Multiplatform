package task_feature.presentation.task_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import task_feature.presentation.components.TaskComposable
import task_feature.presentation.task_list.event.TaskListScreenEvent


@Composable
fun CompletedTaskComponent(
    modifier: Modifier = Modifier,
    viewModel: TaskListScreenViewModel,
    floatingActionButtonSize:Dp,
    showCompletedTasks:Boolean,
    collapse:()->Unit
) {


    Row(
        modifier = Modifier
            .height(60.dp)
            .padding(start = 10.dp, end = 10.dp)
            .fillMaxWidth()
           ,
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
            onClick = collapse
        ) {

            Image(
                modifier = Modifier
                    .size(30.dp),
                imageVector = if(showCompletedTasks) Icons.Filled.KeyboardArrowDown else Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                colorFilter = ColorFilter.tint(Color.Gray),
                contentDescription = null
            )
        }
    }
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ){


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
                    }
                )
            }

            item { Spacer(modifier = Modifier.height(floatingActionButtonSize + 10.dp)) }
        }
    }

}