package di

import core.data.database.Dbclient
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val platFromModule = module {
    singleOf<Dbclient>(::Dbclient)
}