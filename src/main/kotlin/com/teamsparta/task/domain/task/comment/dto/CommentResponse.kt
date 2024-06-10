package com.teamsparta.task.domain.task.comment.dto

data class CommentResponse(
    val id: Long,
    val username : String,
    val content: String?
)
