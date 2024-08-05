package core.navigation

sealed class Screen(val route:String) {

    object LoginScreen: Screen("login_screen")
    object RegistrationScreen: Screen("registration_screen")

    object TaskListScreen: Screen("task_list_screen")
    object AddTaskScreen: Screen("add_task_screen")
}