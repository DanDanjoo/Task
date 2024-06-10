package com.teamsparta.task.domain.task.comment.dto

import jakarta.validation.constraints.Size

data class UpdateCommentRequest (
    val username: String,
    val password: String,

    @field: Size(min = 1, max = 100, message = "내용은 1부터 100자까지 입니다.")
    val content: String?,
    val token : String
)
