package core.data.mapper

import auth.domain.UserDto
import core.data.entity.Task
import core.data.entity.User
import task_feature.domain.TaskDto


fun User.toUserDto():UserDto = UserDto(

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
    status = this.status
)


fun TaskDto.toTask():Task = Task(
    id = this.id,
    title=this.title,
    description = this.description,
    dueDate = this.dueDate,
    status = this.status
)