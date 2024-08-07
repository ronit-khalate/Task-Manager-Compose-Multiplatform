package core.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import core.data.repository.DataStoreRepositoryImpl
import core.navigation.Screen
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import taskmanager.composeapp.generated.resources.Res
import taskmanager.composeapp.generated.resources.compose_multiplatform
import taskmanager.composeapp.generated.resources.logo


@Composable
fun FlashScreen(
    modifier: Modifier = Modifier,
    dataStoreRepository:DataStoreRepositoryImpl,
    navController: NavController
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF27323A)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LaunchedEffect(key1 = Unit) {

            dataStoreRepository.getLoggedInUserId()
                .collect {

                    val userId = it;
                    if (userId == null) {
                        navController.navigate(route = Screen.LoginScreen.route) {
                            popUpTo(Screen.FlashScreen.route)
                        }
                    } else {
                        navController.navigate(route = Screen.TaskListScreen.getRoute(userId)) {
                            popUpTo(Screen.FlashScreen.route)
                        }
                    }


                }

            delay(200)


        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){



            Image(
                modifier = Modifier
                    .height(128.dp)
                    .width(139.75.dp),
                painter = painterResource(Res.drawable.logo),
                contentDescription = "logo",

            )

            Spacer(Modifier.height(24.dp))

            Text(
                text = "Tasks",
                fontSize = 28.sp,
                fontWeight = FontWeight(800),
                color = Color(0xFFFFFFFF)
            )
        }
    }


}