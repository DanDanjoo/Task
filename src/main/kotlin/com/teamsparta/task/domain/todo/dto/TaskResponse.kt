package com.teamsparta.task.domain.todo.dto

data class TaskResponse (
    val id: Long,
    val title: String,
    val description: String?,
)
