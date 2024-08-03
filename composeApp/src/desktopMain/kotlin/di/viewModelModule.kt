package di
import auth.presentation.register.RegisterViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val viewModelModule = module {

    single{
        RegisterViewModel(get())
    }
}