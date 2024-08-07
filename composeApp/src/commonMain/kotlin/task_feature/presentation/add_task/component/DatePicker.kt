package task_feature.presentation.add_task.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.datetime.LocalDate
import network.chaintech.kmp_date_time_picker.ui.datepicker.WheelDatePickerView
import network.chaintech.kmp_date_time_picker.utils.DateTimePickerView
import network.chaintech.kmp_date_time_picker.utils.WheelPickerDefaults
import network.chaintech.kmp_date_time_picker.utils.now

@Composable
fun DatePicker(
    modifier: Modifier = Modifier,
    showDatePicker:Boolean,
    onDoneClicked:(LocalDate)->Unit,
    onDismiss:()->Unit
) {



    WheelDatePickerView(
        modifier = modifier
            .background(color = Color(0xFF435055))
            .fillMaxWidth()
            .padding(top = 22.dp, bottom = 26.dp)
            ,

        showDatePicker = showDatePicker,
        title = "DUE DATE",
        doneLabel = "Done",
        titleStyle = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF29A19C),
        ),
        doneLabelStyle = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF29A19C),
        ),
        startDate = LocalDate.now(),
        dateTextColor = Color(0xff29A19C),
        selectorProperties = WheelPickerDefaults.selectorProperties(
            borderColor = Color.DarkGray,
        ),
        containerColor = Color(0xFF435055),
        rowCount = 5,
        height = 180.dp,
        dateTextStyle = TextStyle(
            fontWeight = FontWeight(600),
        ),
        dragHandle = {
            Divider(
                modifier = Modifier.padding(top = 8.dp).width(50.dp).clip(CircleShape),
                thickness = 4.dp,
                color = Color(0xFFE8E4E4)
            )
        },
        shape = RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp),
        dateTimePickerView = DateTimePickerView.BOTTOM_SHEET_VIEW,
        onDoneClick = onDoneClicked,
        onDismiss = onDismiss,
    )
}