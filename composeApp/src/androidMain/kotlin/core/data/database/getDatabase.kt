package core.data.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver


fun getDataBase(context: Context):Database{

    val dbFile = context.getDatabasePath("database.db")

    return  Room.databaseBuilder<Database>(
        context = context,
        name = dbFile.absolutePath
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}