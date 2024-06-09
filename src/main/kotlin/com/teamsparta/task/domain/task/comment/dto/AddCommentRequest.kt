package com.teamsparta.task.domain.task.comment.dto

data class AddCommentRequest(
    val username: String,
    val password: String,
    val content: String?
)
