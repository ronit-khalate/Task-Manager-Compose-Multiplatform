package core.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.TablerIcons
import compose.icons.tablericons.BoxMultiple
import compose.icons.tablericons.Crosshair
import compose.icons.tablericons.MathSymbols
import compose.icons.tablericons.MedicalCross

@Composable
fun CustomSearchBar(
    modifier: Modifier = Modifier,
    value:String,
    onValueChange:(String)->Unit,
    onSearchClose:() -> Unit,
    placeHolder:String,
) {


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(34.dp)
            .clip(RoundedCornerShape(10.dp)),
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Color(0xFF435055)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {


            BasicTextField(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp),
                value = value,
                onValueChange = onValueChange,
                textStyle = TextStyle(
                    color = Color(0xFFFFFFFF),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                ),


            )
            {



                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp, end = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){


                    Row(
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier
                    ){

                        it()

                    }


                    IconButton(
                        modifier = Modifier,
                        onClick = onSearchClose,
                    ){
                        Image(
                            Icons.Default.Close,
                            contentDescription = "close",
                            colorFilter = ColorFilter.tint(color = Color.LightGray)
                        )
                    }


                }

            }
        }
    }
    
}