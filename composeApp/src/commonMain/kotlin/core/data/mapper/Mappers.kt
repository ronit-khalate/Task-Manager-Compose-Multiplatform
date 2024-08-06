package core.data.mapper

import auth.domain.UserDto
import core.data.entity.Task
import core.data.entity.User
import core.data.entity.UserWithTask
import task_feature.domain.TaskDto
import task_feature.domain.UserWithTasksDto


fun User.toUserDto():UserDto = UserDto(

    id=this.id!!,
    name = this.name,
    email = this.email,
    password = this.password
)

fun UserDto.toUser():User = User(
    name = this.name,
    email = this.email,
    password = this.password
)

fun Task.toTaskDto():TaskDto = TaskDto(
    id = this.id,
    title=this.title,
    description = this.description,
    dueDate = this.dueDate,
    status = this.status,
    userId = this.userId
)


fun TaskDto.toTask():Task = Task(
    id = this.id,
    title=this.title,
    description = this.description,
    dueDate = this.dueDate,
    status = this.status,
    userId = this.userId
)

fun UserWithTask.toUserWithTasksDto():UserWithTasksDto= UserWithTasksDto(
    user = this.user.toUserDto(),
    tasks = this.tasks.map { it.toTaskDto() }

)