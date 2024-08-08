package task_feature.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.TablerIcons
import compose.icons.tablericons.Bold
import compose.icons.tablericons.Filter
import compose.icons.tablericons.Logout
import compose.icons.tablericons.SortAscending
import compose.icons.tablericons.SortDescending
import core.presentation.component.CustomSearchBar
import core.presentation.component.CustomTextField
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.timeout
import task_feature.presentation.task_list.event.TaskListScreenEvent


@OptIn(FlowPreview::class)
@Composable
fun TaskListTopBar(
    modifier: Modifier = Modifier,
    innerPadding:Dp,
    onAscendingButtonClicked:()->Unit,
    onDescendingButtonClicked:()->Unit,
    onLogOut:(enableLogOutButton:()->Unit)->Unit,
    onSearchTextEntered:(String)->Unit

) {

    var isLogOutBtnEnable by remember{ mutableStateOf(true)}

    var isSearching by remember { mutableStateOf(false)}

    var searchText by remember { mutableStateOf("")}

    LaunchedEffect(searchText) {


        if(searchText.isNotBlank()) {


            snapshotFlow {
                searchText
            }
                .debounce(100L)
                .collect {

                    onSearchTextEntered(it)

                }
        }
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(128.dp)
            .padding(start = innerPadding, end = innerPadding-10.dp, top = innerPadding)
            .background(Color(0xFF27323A)),
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {


            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .weight(0.75f)
            ) {


                if (isSearching) {
                    CustomSearchBar(
                        value = searchText,
                        onValueChange = { searchText=it },
                        placeHolder = "Search",
                        onSearchClose = {
                            isSearching = !isSearching
                            searchText=""
                        }
                    )
                } else {

                    Text(
                        text = "Tasks",
                        fontSize = 28.sp,
                        fontWeight = FontWeight(700),
                        color = Color.LightGray

                    )
                }
            }

            Row (
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth(Alignment.End),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.End
            ){




                if (!isSearching) {


                    IconButton(
                        onClick = {
                            isSearching = !isSearching
                        }
                    ) {
                        Image(
                            modifier = Modifier
                                .size(28.dp),
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search Task",
                            colorFilter = ColorFilter.tint(color = Color.LightGray)
                        )
                    }
                }


                Spacer(modifier = Modifier.width(5.dp))

                IconButton(
                    onClick = {
                      isLogOutBtnEnable =false
                      onLogOut{
                          isLogOutBtnEnable = true
                      }
                    },
                    enabled = isLogOutBtnEnable,
                ){
                    Image(
                        modifier = Modifier
                            .size(28.dp),
                        imageVector = TablerIcons.Logout,
                        colorFilter = ColorFilter.tint(Color.LightGray),
                        contentDescription = "Log Out")
                }
            }




        }



        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){
            IconButton(
                onClick = onAscendingButtonClicked
            ){

                Image(
                    modifier = Modifier
                        .size(28.dp),
                    imageVector = TablerIcons.SortAscending,
                    contentDescription = "Sort Ascending",
                    colorFilter = ColorFilter.tint(color = Color.LightGray),
                )
            }

            IconButton(
                onClick = onDescendingButtonClicked,
            ){

                Image(
                    modifier = Modifier
                        .size(28.dp),
                    imageVector = TablerIcons.SortDescending,
                    contentDescription = "Sort Descending",
                    colorFilter = ColorFilter.tint(color = Color.LightGray),
                )
            }

            IconButton(
                onClick = { TODO("Implement Filter Button") }
            ){

                Image(
                    modifier = Modifier
                        .size(28.dp),
                    imageVector = TablerIcons.Filter,
                    contentDescription = "Filter Tasks",
                    colorFilter = ColorFilter.tint(color = Color.LightGray),
                )
            }
        }
    }
}