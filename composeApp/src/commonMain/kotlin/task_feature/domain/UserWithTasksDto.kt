package task_feature.domain

import auth.domain.UserDto
import core.data.entity.User

data class UserWithTasksDto(
    val user: UserDto,
    val tasks:List<TaskDto>
)
