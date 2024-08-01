
import auth.presentation.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module

actual val viewModelModule:Module = module {

    viewModelOf<RegisterViewModel>(::RegisterViewModel)
}