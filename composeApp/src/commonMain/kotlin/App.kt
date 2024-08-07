import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import auth.presentation.login.LoginScreen
import auth.presentation.register.RegistrationScreen
import core.data.repository.DataStoreRepositoryImpl
import core.navigation.Screen
import core.presentation.component.FlashScreen

import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.currentKoinScope
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf
import org.koin.java.KoinJavaComponent.inject
import task_feature.presentation.add_task.AddTaskScreen
import task_feature.presentation.add_task.AddTaskViewModel
import task_feature.presentation.add_task.ViewModelStoreOwenAddTask
import task_feature.presentation.task_list.TaskListScreen
import task_feature.presentation.task_list.TaskListScreenViewModel

@Composable
@Preview
fun App() {
    MaterialTheme {

        KoinContext{

            val dataStoreRepository: DataStoreRepositoryImpl by inject<DataStoreRepositoryImpl>(DataStoreRepositoryImpl::class.java)
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



                    val viewModel: AddTaskViewModel = koinViewModel()
                    AddTaskScreen(viewModel = viewModel, navController = navController)
                }

                composable(
                    route = Screen.TaskListScreen.route,
                    arguments = Screen.TaskListScreen.argument
                ){

                    val viewModel: TaskListScreenViewModel   = koinViewModel()
                    TaskListScreen(
                        navController = navController,
                        viewModel = viewModel,
                    )
                }

            }
        }

    }
}

@Composable
inline fun <reified T:ViewModel>koinViewModel():T {

    val scope = currentKoinScope()
    return  viewModel {
        scope.get<T>()
    }
}