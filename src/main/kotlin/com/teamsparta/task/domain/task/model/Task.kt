package com.teamsparta.task.domain.task.model

import com.teamsparta.task.domain.task.comment.model.Comment
import com.teamsparta.task.domain.task.dto.TaskResponse
import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
@Table(name = "task")
class Task(

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

    ) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

}

    fun Task.toResponse(): TaskResponse {
        return TaskResponse(
            id = id!!,
            title = title,
            description = description,


        )
    }


