package di

import auth.data.repository.RegistrationRepositoryImp
import auth.domain.repository.RegistrationRepository
import org.koin.dsl.bind
import org.koin.dsl.module


val appModule = module {

        single {

            RegistrationRepositoryImp(get())
        }

}