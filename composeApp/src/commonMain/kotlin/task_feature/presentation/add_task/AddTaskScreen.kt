package task_feature.presentation.add_task

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.TablerIcons
import compose.icons.tablericons.Calendar
import compose.icons.tablericons.Camera
import core.presentation.component.CustomButton
import task_feature.domain.TaskDto
import task_feature.presentation.add_task.event.AddTaskScreenEvent
import task_feature.presentation.components.AddTaskTopBar

@Composable
fun AddTaskScreen(
    modifier: Modifier = Modifier,
    viewModel: AddTaskViewModel
) {

    val listInnerPadding = 24.dp
    val minCardHeight = 256.dp
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = { AddTaskTopBar(innerPadding = listInnerPadding) },
        backgroundColor = Color(0xFF27323A)
    ) {

        Column(

            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(vertical = listInnerPadding, horizontal = listInnerPadding)
            ,


            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {


                Card(
                    backgroundColor = Color(0xFF435055),
                    modifier = modifier
                        .fillMaxWidth()
                        .heightIn(min = minCardHeight),
                    shape = RoundedCornerShape(20.dp),

                ) {
                    Column(
                        modifier = Modifier
                            .heightIn(min = minCardHeight)
                            .padding(vertical = listInnerPadding, horizontal = listInnerPadding),
                        verticalArrangement = Arrangement.SpaceBetween,
                    )
                    {

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                        ) {


                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween


                            ) {

                                BasicTextField(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = viewModel.state.title,
                                    onValueChange = {viewModel.onEvent(AddTaskScreenEvent.OnTitleEntered(it))},
                                    enabled = true,
                                    textStyle = TextStyle(
                                        color = Color(0xFF29A19C),  // Set text color to white for visibility
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight(700),
                                    ),
                                ) {

                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ){

                                        if (viewModel.state.title.isBlank()) {
                                            Text(
                                                "title",
                                                color = Color.Gray,
                                                fontSize = 18.sp,
                                                fontWeight = FontWeight(700)
                                            )
                                        }

                                        it()
                                    }
                                }



                            }
                            Spacer(modifier = Modifier.height(10.dp))


                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween


                            ) {
                                BasicTextField(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(5.dp)
                                        .wrapContentHeight(),  // Added padding for better visibility
                                    value = viewModel.state.description,
                                    onValueChange = {viewModel.onEvent(AddTaskScreenEvent.OnDescriptionEntered(it))},
                                    enabled = true,
                                    textStyle = TextStyle(
                                        color = Color(0xFF29A19C),  // Set text color to white for visibility
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight(400)
                                    ),

                                ) {



                                        if (viewModel.state.description.isBlank()) {
                                            Text(
                                                "description",
                                                color = Color.Gray,
                                                fontSize = 14.sp,
                                                fontWeight = FontWeight(400)
                                            )
                                        }

                                        it()

                                }


                            }


                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 5.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End
                        ) {

                            IconButton(
                                modifier = Modifier,
                                onClick = {}
                            ){
                               Image(
                                   modifier = Modifier
                                       .size(28.dp),
                                   colorFilter = ColorFilter.tint(Color.LightGray),
                                   imageVector = TablerIcons.Calendar,
                                   contentDescription = "Due Date"
                               )
                            }


//                            Spacer(Modifier.width(10.dp))

                            IconButton(
                                modifier = Modifier,
                                onClick = {}
                            ){
                               Image(
                                   modifier = Modifier
                                       .size(28.dp),
                                   imageVector = TablerIcons.Camera,
                                   colorFilter = ColorFilter.tint(Color.LightGray),
                                   contentDescription = "Due Date"
                               )
                            }



                            IconButton(
                                modifier = Modifier,
                                onClick = {viewModel.onEvent(AddTaskScreenEvent.OnStatusButtonClicked)}
                            ){
                                Canvas(
                                    modifier = Modifier,

                                    ) {
                                    drawCircle(

                                        color = if (viewModel.state.status) Color(0xFF29A19C) else Color(
                                            0xFF27323A
                                        ),
                                        radius = 40f
                                    )

                                    drawCircle(
                                        color = Color(0xFF435055),
                                        radius = 30f
                                    )

                                    if (viewModel.state.status) {
                                        drawCircle(
                                            color = Color(0xFF29A19C),
                                            radius = 20f
                                        )
                                    }


                                }
                            }





                        }

                    }

                }

            Spacer(modifier = Modifier.height(24.dp))

           CustomButton(
               onClick = {
                   viewModel.onEvent(AddTaskScreenEvent.OnAddTask)
               },
               buttonText = "Add Task"
           )





        }
    }

}