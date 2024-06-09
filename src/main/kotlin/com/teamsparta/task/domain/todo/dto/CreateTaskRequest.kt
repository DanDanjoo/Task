package com.teamsparta.task.domain.todo.dto

data class CreateTaskRequest (
    val title: String,
    val description: String?,
)