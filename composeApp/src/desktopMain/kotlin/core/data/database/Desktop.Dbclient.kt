package core.data.database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import java.io.File

actual class Dbclient{

    val dbFile = File(System.getProperty("java.io.tmpdir"),"database.db")

    operator fun invoke():Database = Room.databaseBuilder<Database>(
        name = dbFile.absolutePath
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}