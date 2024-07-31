package auth.presentation.register

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun RegistrationScreen( modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp,end=20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, bottom = 40.dp),
            elevation = 20.dp,

            border = BorderStroke(width = 2.dp, color = MaterialTheme.colors.secondary)
        ) {


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),

                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally


            ) {

                Spacer(Modifier.height(40.dp))

                Text(
                    text = "Register",
                    fontSize = 30.sp,
                    fontStyle = FontStyle.Normal,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(20.dp))


                Text(
                    text = "Create Your Account It's Free And Only Takes a Minute",
                    color = Color.Gray
                )

                Spacer(Modifier.height(30.dp))

                OutlinedTextField(
                    shape = RoundedCornerShape(30.dp),
                    value = "",
                    singleLine = true,
                    onValueChange = {TODO("Implement on value change")},
                    label = { Text("First Name") }

                )

                Spacer(Modifier.height(10.dp))

                OutlinedTextField(
                    shape = RoundedCornerShape(30.dp),
                    value = "",
                    singleLine = true,
                    onValueChange = {TODO("Implement on value change")},
                    label = { Text("Last Name") }

                )

                Spacer(Modifier.height(10.dp))

                OutlinedTextField(
                    shape = RoundedCornerShape(30.dp),
                    value = "",
                    singleLine = true,
                    onValueChange = {TODO("Implement on value change")},
                    label = { Text("Email") }

                )

                Spacer(Modifier.height(10.dp))

                OutlinedTextField(
                    shape = RoundedCornerShape(30.dp),
                    value = "",
                    singleLine = true,
                    onValueChange = {TODO("Implement on value change")},
                    label = { Text("Password") }

                )
                Spacer(Modifier.height(10.dp))

                OutlinedTextField(
                    shape = RoundedCornerShape(30.dp),
                    value = "",
                    singleLine = true,
                    onValueChange = {TODO("Implement on value change")},
                    label = { Text("Confirm Password") }

                )

                Spacer(Modifier.height(20.dp))

                OutlinedButton(
                    modifier = Modifier
                        .padding(start = 40.dp, end = 40.dp)
                        .fillMaxWidth()
                        .height(40.dp),
                    onClick ={ TODO("Implement Onclick") },
                    shape = RoundedCornerShape(40.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary)

                ){
                    Text("Register")
                }
                Spacer(Modifier.height(40.dp))
            }

        }

    }

}



@Preview
@Composable
fun RegistrationScreenPreview() {
    RegistrationScreen()
}