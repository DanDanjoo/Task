package com.teamsparta.task.domain.task.comment.repository

import com.teamsparta.task.domain.task.comment.model.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository: JpaRepository<Comment, Long> {
}