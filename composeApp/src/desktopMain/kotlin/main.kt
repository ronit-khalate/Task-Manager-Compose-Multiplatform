import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import auth.presentation.register.RegistrationScreen
import di.KoinInitializer

fun main() = application {

    KoinInitializer().init()
    Window(
        onCloseRequest = ::exitApplication,
        title = "TaskManager",
    ) {
        App()
    }
}