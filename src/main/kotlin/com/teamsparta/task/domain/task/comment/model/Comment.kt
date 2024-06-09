package com.teamsparta.task.domain.task.comment.model

import com.teamsparta.task.domain.task.comment.dto.CommentResponse
import com.teamsparta.task.domain.task.model.Task

import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
@Table(name = "comment")
class Comment (

    @Column(name = "username")
    var username: String,

    @Column(name = "password")
    var password: String,

    @Column(name = "content")
    var content: String?,

    @Column(name = "created_at")
    var createdAt : LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at")
    var updatedAt : LocalDateTime = LocalDateTime.now(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    var task: Task,




    ) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    fun checkAuthentication(username: String, password: String) {
        if (username != this.username) {
            throw Exception("잘못된 username 입니다!")
        }
        if (password != this.password) {
            throw Exception("잘못된 password 입니다!")

        }
    }

    fun changeContent(content: String?) {
        this.content = content

    }
}



fun Comment.toResponse(): CommentResponse{
    return CommentResponse(
        username = username,
        password = password,
        content = content,


    )
}