package task_feature.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.TablerIcons
import org.jetbrains.compose.ui.tooling.preview.Preview
import task_feature.domain.TaskDto


@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun TaskComposable(
    modifier: Modifier = Modifier,
    task:TaskDto,
    onStatusClicked:()->Unit,
    onDelete:()->Unit,
    onTitleChanged:(String)->Unit,
    onDescriptionChanged:(String)->Unit,
) {

    var expanded by remember { mutableStateOf(false) }

    var cardColor by remember {

        if(!task.status){
            mutableStateOf(Color(0xFF435055))
        }
        else{
            mutableStateOf( Color(0xFF343738))
        }

    }
    var titleColor by remember {  mutableStateOf(Color(0xFF29A19C) )}

    var status by remember { mutableStateOf(task.status) }

    var isEditing by remember { mutableStateOf(false) }




        Card(
            backgroundColor = cardColor,
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 64.dp   ),
            shape = RoundedCornerShape(20.dp),
            onClick = {expanded = !expanded}
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValues = PaddingValues(18.dp))
                    .wrapContentHeight(),
                verticalArrangement = Arrangement.Top,

                ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween


                ) {

                    BasicTextField(
                        modifier = Modifier
                            .wrapContentWidth(),  // Added padding for better visibility
                        value = task.title,
                        onValueChange = onTitleChanged,
                        enabled = isEditing,
                        textStyle = TextStyle(
                            color = titleColor,  // Set text color to white for visibility
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    ){
                        it()
                    }


                    Row(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(end = 5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(end = 20.dp),
                            text = task.dueDate,
                            fontSize = 16.sp,
                            color = Color.LightGray
                        )

                        Spacer(Modifier.width(10.dp))





                        IconButton(onClick = {
                            status=!status
                            cardColor= Color(0xFF343738)
                            titleColor = Color.LightGray
                            onStatusClicked()
                        }) {


                            Canvas(
                                modifier = Modifier

                            ) {
                                drawCircle(
                                    color = if (status) Color(0xFF29A19C) else Color(0xFF27323A),
                                    radius = 28f
                                )

                                drawCircle(
                                    color = Color(0xFF435055),
                                    radius = 24f
                                )

                                if (status) {
                                    drawCircle(
                                        color = Color(0xFF29A19C),
                                        radius = 20f
                                    )
                                }


                            }
                        }


                    }


                }


                AnimatedVisibility(expanded) {

                    Column(
                        modifier = Modifier
                            .wrapContentSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {


                        Spacer(Modifier.height(15.dp))
                        // Description
                        BasicTextField(
                            value = task.description,
                            textStyle = TextStyle(
                                fontSize = 16.sp,
                                color = Color.LightGray
                            ),
                            onValueChange = onDescriptionChanged,
                            enabled = isEditing,
                            singleLine = false

                        ){
                            it()
                        }

                        Spacer(Modifier.height(25.dp))

                        Row(
                            modifier
                                .fillMaxWidth()
                                .wrapContentHeight(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End
                        ) {

                            IconButton(
                                onClick = {

                                    if(isEditing){

                                    }
                                    isEditing = !isEditing}

                            ) {
                                Image(
                                    modifier = Modifier
                                        .size(24.dp),
                                    imageVector = if(!isEditing)Icons.Default.Edit else Icons.Default.Done,
                                    contentDescription = "Edit",
                                    colorFilter = ColorFilter.tint(Color.Gray)
                                )
                            }


                            Spacer(Modifier.width(20.dp))
                            IconButton(onClick = {
                                onDelete()
                                cardColor = Color(0xFF663131)
                            }) {
                                Image(
                                    modifier = Modifier
                                        .size(24.dp),
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "Delete",
                                    colorFilter = ColorFilter.tint(Color.Gray)
                                )
                            }
                        }

                    }
                }
            }

        }

    Spacer(Modifier.height(20.dp))
}

@Preview
@Composable
fun Preview(modifier: Modifier = Modifier) {

}