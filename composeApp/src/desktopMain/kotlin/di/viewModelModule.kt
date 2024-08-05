package di
import auth.data.repository.LoginRepositoryImpl
import auth.domain.repository.LoginRepository
import auth.domain.repository.RegistrationRepository
import auth.presentation.login.LoginScreenViewModel
import auth.presentation.register.RegisterViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

actual val viewModelModule = module {

    single{
        RegisterViewModel(get())

    }

    single {


        LoginRepositoryImpl(get())
    }.bind(LoginRepository::class)
}