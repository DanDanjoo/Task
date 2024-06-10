package com.teamsparta.task.domain.task.comment.dto

import com.teamsparta.task.domain.task.comment.model.Comment

data class CommentResponse(
    val id: Long?,
    val username: String,
    val content: String?
) {
    companion object {
        fun from(comment: Comment): CommentResponse {
            return CommentResponse(comment.id, comment.username, comment.content)
        }
    }
}