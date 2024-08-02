package core.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDate


@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val title:String,
    val description:String,
    val dueDate:LocalDate,
    val status:Boolean
)
