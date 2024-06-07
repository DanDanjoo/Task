package com.teamsparta.task.domain.todo.dto

data class TodoResponse (
    val id: Long,
    val title: String,
    val description: String?,
)
