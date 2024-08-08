package core.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import auth.domain.UserDto
import core.createDataStore
import core.data.database.UserSettings
import core.data.database.dataStoreFileName
import core.domain.repository.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.koin.java.KoinJavaComponent.inject

class DataStoreRepositoryImpl(
        private val dataStore: DataStore<Preferences>
):DataStoreRepository {


    companion object{
        val USER_ID_KEY = intPreferencesKey("logged_in_user_id")
    }
    override suspend fun saveLoggedInUser(userDto: UserDto): Boolean {
        return try {
            dataStore.edit { preferences->
                preferences.set(key = USER_ID_KEY, value = userDto.id)
            }
            true
        }
        catch (e:Exception){

            false

        }
    }

    override suspend fun removeLoggedInUser(): Boolean {
        return try {
            dataStore.edit {
                it.remove(USER_ID_KEY)
            }
            true
        }
        catch (e:Exception){
            false
        }
    }

    override suspend fun getLoggedInUserId():Flow<Int?> {
       return dataStore.data.map {preferences->

              val id=  preferences[USER_ID_KEY]?.toInt()

           id

       }

    }
}