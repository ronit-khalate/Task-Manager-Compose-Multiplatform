package core.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.sun.jdi.connect.Connector.Argument

sealed class Screen(val route:String) {

    data object LoginScreen: Screen("login_screen")
    data object RegistrationScreen: Screen("registration_screen")
    data object FlashScreen:Screen("flash_screen")

    data object TaskListScreen: Screen("task_list_screen/{user_id}"){



           const val ARGUMENT ="user_id"
            val argument = listOf( navArgument(ARGUMENT){ NavType.IntType})

        fun getRoute(userId: Int):String = "task_list_screen/{$userId}"

    }
    data object AddTaskScreen: Screen("add_task_screen/{user_id}"){
        const val ARGUMENT ="user_id"
        val argument = listOf(navArgument(ARGUMENT){NavType.IntType})

        fun getRoute(userId: Int):String = "add_task_screen/{$userId}"

    }
}