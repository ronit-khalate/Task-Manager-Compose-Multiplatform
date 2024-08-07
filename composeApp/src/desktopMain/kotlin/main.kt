import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import auth.presentation.login.LoginScreen
import auth.presentation.register.RegistrationScreen
import core.data.repository.DataStoreRepositoryImpl
import core.navigation.Screen
import core.presentation.component.FlashScreen
import di.KoinInitializer
import org.koin.core.parameter.parametersOf
import org.koin.java.KoinJavaComponent.inject
import task_feature.presentation.add_task.AddTaskScreen
import task_feature.presentation.add_task.AddTaskViewModel
import task_feature.presentation.add_task.ViewModelStoreOwenAddTask
import task_feature.presentation.task_list.TaskListScreen
import task_feature.presentation.task_list.TaskListScreenViewModel

fun main() = application {

    KoinInitializer().init()

    Window(
        onCloseRequest = ::exitApplication,
        title = "TaskManager",
    ) {

        val dataStoreRepository: DataStoreRepositoryImpl by inject<DataStoreRepositoryImpl>(DataStoreRepositoryImpl::class.java)
        Row(modifier = Modifier
            .fillMaxSize(),

        ){
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


                }

                composable(
                    route = Screen.TaskListScreen.route,
                    arguments = Screen.TaskListScreen.argument
                ){

                    val taskListScreenViewModel: TaskListScreenViewModel = koinViewModel()
                   val addTaskViewModel :AddTaskViewModel = koinViewModel()
                    HomeScreen(
                        navController = navController,
                        taskListScreenViewModel = taskListScreenViewModel,
                        addTaskViewModel = addTaskViewModel

                    )
                }

            }
        }
    }
}