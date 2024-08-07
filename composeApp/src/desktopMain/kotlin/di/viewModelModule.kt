package di
import auth.data.repository.LoginRepositoryImpl
import auth.domain.repository.LoginRepository
import auth.domain.repository.RegistrationRepository
import auth.presentation.login.LoginScreenViewModel
import auth.presentation.register.RegisterViewModel
import core.data.repository.DataStoreRepositoryImpl
import core.domain.repository.DataStoreRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import task_feature.presentation.add_task.AddTaskViewModel
import task_feature.presentation.task_list.TaskListScreenViewModel

actual val viewModelModule = module {

    single {
        RegisterViewModel(get(),get())


    }

    single {
        LoginScreenViewModel(get(),get())
    }

    single {
        TaskListScreenViewModel(get(),get())
    }

    single {
        AddTaskViewModel(get(),get())
    }

    single {
        DataStoreRepositoryImpl(get())
    }.bind(DataStoreRepository::class)

}