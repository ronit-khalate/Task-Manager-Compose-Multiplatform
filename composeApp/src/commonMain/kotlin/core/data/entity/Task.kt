package core.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.util.TableInfo
import kotlinx.datetime.LocalDate


@Entity(
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("userId"),
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index(value = ["userId"])]
)
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id:Int?=null,
    val title:String,
    val description:String,
    val dueDate:String,
    val status:Boolean=false,
    val userId:Int
)
