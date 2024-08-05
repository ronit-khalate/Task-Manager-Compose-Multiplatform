package core

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import core.data.database.UserSettings
import core.data.database.dataStoreFileName

actual fun createDataStore(context:Any?): DataStore<Preferences> {

    return UserSettings.getDataStore {
        dataStoreFileName
    }
}