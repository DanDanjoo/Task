package com.teamsparta.task.domain.task.dto

data class TaskResponse (
    val id: Long,
    val title: String,
    val description: String?,
)
