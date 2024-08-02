package core.data.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

actual class Dbclient(private val context: Context) {

    val dbFile = context.getDatabasePath("database.db")

    operator fun invoke():Database = Room.databaseBuilder<Database>(
        context = context,
        name = dbFile.absolutePath
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}