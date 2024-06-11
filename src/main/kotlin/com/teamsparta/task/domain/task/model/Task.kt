package com.teamsparta.task.domain.task.model

import com.teamsparta.task.domain.task.comment.model.Comment
import com.teamsparta.task.domain.task.dto.TaskResponse
import com.teamsparta.task.domain.users.model.Users
import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
@Table(name = "task")
class Task(

    @Column(name = "username")
    var username: String,

    @Column(name = "title")
    var title: String,

    @Column(name = "description")
    var description: String? = null,

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime = LocalDateTime.now(),

    @OneToMany(mappedBy = "task", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var comment : MutableList<Comment> = mutableListOf(),
//
//    @ManyToOne
//    val author: Users


    ) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column
    private var completed: Boolean = false

    fun complete(){
        completed = true

    }

}

    fun Task.toResponse(): TaskResponse {
        return TaskResponse(
            id = id!!,
            username = username,
            title = title,
            description = description,

        )
    }


