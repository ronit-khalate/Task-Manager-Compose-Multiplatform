package core.data.database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import java.io.File


actual class RoomClient{
    actual fun getDatabase(): Database {

        val dbFile = File(System.getProperty("java.io.tmpdir"),"database.db")

        return Room.databaseBuilder<Database>(
            name = dbFile.absolutePath
        )
            .setDriver(BundledSQLiteDriver())
            .build()
    }

}