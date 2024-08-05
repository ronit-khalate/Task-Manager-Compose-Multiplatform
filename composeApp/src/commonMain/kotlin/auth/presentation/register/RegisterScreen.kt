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
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import auth.presentation.register.event.RegisterScreenEvent
import core.presentation.component.CustomButton
import core.presentation.component.CustomTextField
import koinViewModel
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun RegistrationScreen( modifier: Modifier = Modifier) {

    val viewModel:RegisterViewModel = koinViewModel()

    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }

    if(viewModel.state.showSnackBar){

       scope.launch {

            snackBarHostState.showSnackbar(viewModel.state.snackBarMessage, duration = SnackbarDuration.Short)
           viewModel.onEvent(RegisterScreenEvent.RestSnackBarState)


       }
    }


    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
        ,
        backgroundColor = Color(0xFF27323A),
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        }
    ) {


        Column(
            modifier = Modifier
                .padding(it)
                .padding(top = 20.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState(), reverseScrolling = true)
                .padding(start = 20.dp, end = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),

                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Welcome",
                    fontSize = 28.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                )

                Text(
                    text = "To",
                    fontSize = 28.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                )
                Text(
                    text = "Task Manager!",
                    fontSize = 28.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                )

                Spacer(modifier = Modifier.height(24.dp))

                CustomTextField(
                    value = viewModel.state.name,
                    onValueChange = {
                        viewModel.onEvent(RegisterScreenEvent.OnNameEntered(it))
                    },
                    placeHolder = "Enter Name"
                )

                Spacer(modifier = Modifier.height(20.dp))

                CustomTextField(
                    value = viewModel.state.email,
                    onValueChange = {
                        viewModel.onEvent(RegisterScreenEvent.OnEmailEntered(it))
                    },
                    placeHolder = "Enter Email"
                )

                Spacer(modifier = Modifier.height(20.dp))

                CustomTextField(
                    value = viewModel.state.password,
                    onValueChange = {
                        viewModel.onEvent(RegisterScreenEvent.OnPasswordEntered(it))
                    },
                    placeHolder = "Create Password"
                )

                Spacer(modifier = Modifier.height(20.dp))

                CustomTextField(
                    value = viewModel.state.confirmPassword,
                    onValueChange = {
                        viewModel.onEvent(RegisterScreenEvent.OnConfiremPasswordEntered(it))
                    },
                    placeHolder = "Confirm Password"
                )

                Spacer(modifier = Modifier.height(20.dp))

                CustomButton(
                    onClick = {
                        viewModel.onEvent(RegisterScreenEvent.OnRegister)
                    },
                    buttonText = "Sign Up"
                )
                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Already have an account? ",
                        fontSize = 14.sp,
                        color = Color(0xFFFFFFFF)

                    )

                    TextButton(
                        onClick = {}
                    ){
                        Text(
                            text = "sign in",
                            color = Color(0xFF29A19C)
                        )
                    }
                }



            }

        }
    }

}



@Preview
@Composable
fun RegistrationScreenPreview() {
    RegistrationScreen()
}