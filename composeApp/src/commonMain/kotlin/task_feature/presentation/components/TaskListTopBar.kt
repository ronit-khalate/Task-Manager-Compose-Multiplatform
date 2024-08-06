package task_feature.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
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
import compose.icons.tablericons.SortAscending
import compose.icons.tablericons.SortDescending


@Composable
fun TaskListTopBar(
    modifier: Modifier = Modifier,
    innerPadding:Dp
) {

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
                .height(60.dp) ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Tasks",
                fontSize = 28.sp,
                fontWeight = FontWeight(700),
                color = Color.LightGray

            )
            IconButton(
                onClick = {TODO("Impelemetn Search Task")}
            ){
                Image(
                    modifier = Modifier
                        .size(28.dp),
                    imageVector =Icons.Default.Search,
                    contentDescription = "Search Task",
                    colorFilter = ColorFilter.tint(color = Color.LightGray)
                )
            }

        }



        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){
            IconButton(
                onClick = { TODO("Implement Ascending Button") }
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
                onClick = { TODO("Implement Sort Descending Button") }
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