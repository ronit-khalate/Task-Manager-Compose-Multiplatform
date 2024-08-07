package com.ronit.project

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
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

                    val userId = it.arguments?.getInt(Screen.AddTaskScreen.ARGUMENT)

                    val viewModel:AddTaskViewModel = getViewModel<AddTaskViewModel> { parametersOf(userId)}
                    AddTaskScreen(viewModel = viewModel, navController = navController)
                }

                composable(
                    route = Screen.TaskListScreen.route,
                    arguments = Screen.TaskListScreen.argument
                ){

                    val userId = it.arguments?.getInt(Screen.TaskListScreen.ARGUMENT)


                   val viewModel:TaskListScreenViewModel = koinViewModel(parameters = { parametersOf(userId) })
                    TaskListScreen(
                        navController = navController,
                        viewModel = viewModel,
                    )
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