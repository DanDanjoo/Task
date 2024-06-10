package com.teamsparta.task.domain.task.dto

import jakarta.validation.constraints.Size

data class CreateTaskRequest (
    val username : String,

    @field: Size(min = 1, max = 10, message = "제목은 1부터 10자까지 입니다.")
    val title: String,
    @field: Size(min = 1, max = 100, message = "내용은 1부터 100자까지 입니다.")
    val description: String?,
    val token : String
)