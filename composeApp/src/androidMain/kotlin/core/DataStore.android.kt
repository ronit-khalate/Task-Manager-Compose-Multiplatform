package core

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import core.data.database.UserSettings
import core.data.database.dataStoreFileName

actual fun createDataStore(context: Any?): DataStore<Preferences> {

    require(
        context is Context
    )

    return  UserSettings.getDataStore {
        context.filesDir
            .resolve(dataStoreFileName)
            .absolutePath
    }
}