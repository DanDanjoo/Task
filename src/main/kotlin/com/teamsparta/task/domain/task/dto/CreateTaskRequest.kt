package com.teamsparta.task.domain.task.dto

data class CreateTaskRequest (
    val title: String,
    val description: String?,
)