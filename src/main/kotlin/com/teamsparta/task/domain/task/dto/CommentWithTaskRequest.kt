package com.teamsparta.task.domain.task.dto

import com.teamsparta.task.domain.task.comment.dto.CommentResponse
import com.teamsparta.task.domain.task.model.Task

data class CommentWithTaskRequest(
    var username: String,
    val title: String,
    val description: String?,
    val comment: List<CommentResponse>
) {

    companion object {
        fun from(tasks: Task): CommentWithTaskRequest {
            return CommentWithTaskRequest(
                tasks.username,
                tasks.title,
                tasks.description,
                tasks.comment.map { CommentResponse.from(it) } // 이 부분 수정
            )
        }
    }
}
