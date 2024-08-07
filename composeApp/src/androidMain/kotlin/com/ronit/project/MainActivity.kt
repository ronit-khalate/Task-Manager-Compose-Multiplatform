package com.ronit.project

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import auth.presentation.login.LoginScreen
import auth.presentation.register.RegistrationScreen
import core.data.repository.DataStoreRepositoryImpl
import core.navigation.Screen
import core.presentation.component.FlashScreen
import org.koin.android.ext.android.inject
import org.koin.androidx.compose.koinViewModel

import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.parameter.parametersOf
import org.koin.core.scope.Scope
import task_feature.presentation.add_task.AddTaskScreen
import task_feature.presentation.add_task.AddTaskViewModel
import task_feature.presentation.add_task.ViewModelStoreOwenAddTask
import task_feature.presentation.task_list.TaskListScreen
import task_feature.presentation.task_list.TaskListScreenViewModel

class MainActivity : ComponentActivity() {

    val dataStoreRepository: DataStoreRepositoryImpl by inject<DataStoreRepositoryImpl>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        WindowCompat.setDecorFitsSystemWindows(window,false)
        enableEdgeToEdge()






        setContent {

            val navController = rememberNavController()

           

            NavHost(navController =navController , startDestination = Screen.FlashScreen.route ,){
                
                composable(route = Screen.FlashScreen.route){
                    
                    FlashScreen(dataStoreRepository = dataStoreRepository, navController = navController)
                }

                composable(route = Screen.LoginScreen.route){

                    LoginScreen(navController = navController)
                }

                composable(route= Screen.RegistrationScreen.route){

                    RegistrationScreen(navController = navController)
                }

                composable(
                    route = Screen.AddTaskScreen.route,
                    arguments = Screen.AddTaskScreen.argument
                ){

                    val viewModel:AddTaskViewModel = koinViewModel(viewModelStoreOwner =ViewModelStoreOwenAddTask )
                    AddTaskScreen(viewModel = viewModel, navController = navController)
                }

                composable(
                    route = Screen.TaskListScreen.route,
                    arguments = Screen.TaskListScreen.argument
                ){
                   val viewModel:TaskListScreenViewModel = koinViewModel()
                    TaskListScreen(
                        navController = navController,
                        viewModel = viewModel,
                    ){
                        val floatingActionButtonSize = 60.dp
                        FloatingActionButton(
                            modifier = Modifier
                                .size(floatingActionButtonSize),
                            onClick = {
                                navController.navigate(route = Screen.AddTaskScreen.getRoute(viewModel.userId)){
                                    launchSingleTop=true
                                }
                            },
                            shape = CircleShape,
                            backgroundColor = Color(0xFF435055)
                        ){
                            Image(
                                modifier = Modifier
                                    .size(35.dp),
                                imageVector = Icons.Default.Add,
                                contentDescription = "Add Task",
                                colorFilter = ColorFilter.tint(color = Color(0xFFA3F7BF))
                            )
                        }
                    }
                }

            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}