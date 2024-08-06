package core.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import core.data.repository.DataStoreRepositoryImpl
import core.navigation.Screen


@Composable
fun FlashScreen(
    modifier: Modifier = Modifier,
    dataStoreRepository:DataStoreRepositoryImpl,
    navController: NavController
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF27323A))
    ) {

        LaunchedEffect(key1 = Unit) {

            dataStoreRepository.getLoggedInUserId()
                .collect {

                    val userId = it;
                    if(userId == null){
                        navController.navigate(route = Screen.LoginScreen.route){
                            popUpTo(Screen.FlashScreen.route)
                        }
                    }else{
                        navController.navigate(route = Screen.TaskListScreen.getRoute(userId)){
                            popUpTo(Screen.FlashScreen.route)
                        }
                    }


                }


        }
    }
}