import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import auth.presentation.register.RegistrationScreen

fun main() = application {

    KoinInitializer().init()
    Window(
        onCloseRequest = ::exitApplication,
        title = "TaskManager",
    ) {
        RegistrationScreen()
    }
}