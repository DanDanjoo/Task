package com.teamsparta.task.domain.task.dto

data class TaskResponse (
    val id: Long,
    var username: String,
    val title: String,
    val description: String?,

)
