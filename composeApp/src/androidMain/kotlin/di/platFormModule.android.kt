package di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import core.createDataStore
import core.data.database.Database
import core.data.database.RoomClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val platFromModule = module{

    single<Database> {
        RoomClient(get()).getDatabase()
    }

    single <DataStore<Preferences>>{
        createDataStore(get<Context>())
    }


}