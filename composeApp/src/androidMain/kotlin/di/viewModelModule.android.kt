package di
import auth.presentation.login.LoginScreenViewModel
import auth.presentation.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module

actual val viewModelModule:Module = module {

    viewModel {
        RegisterViewModel(get())


    }

    viewModel {
        LoginScreenViewModel(get())
    }
}