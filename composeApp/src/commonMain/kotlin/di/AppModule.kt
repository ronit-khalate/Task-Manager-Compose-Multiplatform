package di

import auth.data.repository.LoginRepositoryImpl
import auth.data.repository.RegistrationRepositoryImp
import auth.domain.repository.LoginRepository
import auth.domain.repository.RegistrationRepository
import core.data.repository.DataStoreRepositoryImpl
import core.domain.repository.DataStoreRepository
import org.koin.core.scope.get
import org.koin.dsl.bind
import org.koin.dsl.module
import task_feature.data.repository.AddTaskRepositoryImpl
import task_feature.data.repository.TaskListRepositoryImpl
import task_feature.domain.repository.AddTaskRepository
import task_feature.domain.repository.TaskListRepository
import kotlin.math.sin


val appModule = module {

        single {
            RegistrationRepositoryImp(get())

        }.bind(RegistrationRepository::class)

        single {
            LoginRepositoryImpl(get())
        }.bind(LoginRepository::class)

        single {
            DataStoreRepositoryImpl(get())
        }.bind(DataStoreRepository::class)


        single {
            TaskListRepositoryImpl(get())
        }.bind(TaskListRepository::class)

        single {
            AddTaskRepositoryImpl(get())
        }.bind(AddTaskRepository::class)

}