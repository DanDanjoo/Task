package com.teamsparta.task.domain.task.comment.dto

data class UpdateCommentRequest (
    val username: String,
    val password: String,
    val content: String?
)
