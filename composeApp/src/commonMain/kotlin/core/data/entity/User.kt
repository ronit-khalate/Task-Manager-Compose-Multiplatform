package core.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(

    @PrimaryKey(autoGenerate = true)
    val id:Int?=null,
    val name:String,
    val email:String,
    val password:String
)
