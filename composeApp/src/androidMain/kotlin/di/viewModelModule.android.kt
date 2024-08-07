package di
import auth.presentation.login.LoginScreenViewModel
import auth.presentation.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module
import task_feature.presentation.add_task.AddTaskViewModel
import task_feature.presentation.task_list.TaskListScreenViewModel

actual val viewModelModule:Module = module {

    viewModel {
        RegisterViewModel(get(),get())


    }

    viewModel {
        LoginScreenViewModel(get(),get())
    }

    viewModel {
        TaskListScreenViewModel(get(),get())
    }

    viewModel {
        AddTaskViewModel(get(),get())
    }
}