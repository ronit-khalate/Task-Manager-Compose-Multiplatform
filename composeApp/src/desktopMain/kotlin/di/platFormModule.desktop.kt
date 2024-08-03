package di

import core.data.database.Database
import core.data.database.RoomClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val platFromModule = module {
    single <Database>{
        RoomClient().getDatabase()
    }
}