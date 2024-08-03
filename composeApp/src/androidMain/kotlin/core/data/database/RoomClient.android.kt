package core.data.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

actual class RoomClient(private val context: Context){
    actual fun getDatabase(): Database {

        val dbFile = context.getDatabasePath("database.db")
        return Room.databaseBuilder<Database>(
            context = context,
            name = dbFile.absolutePath
        )
            .setDriver(BundledSQLiteDriver())
            .build()
    }

}