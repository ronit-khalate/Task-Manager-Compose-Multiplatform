package core.data.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

data class UserWithTask(
    @Embedded val user: User,

    @Relation(
        parentColumn = "id",
        entityColumn = "userId"
    )
    val tasks:List<Task>
)