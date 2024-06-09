package com.teamsparta.task.domain.todo.model

import com.teamsparta.task.domain.todo.dto.TaskResponse
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime


@Entity(name = "task")
class Task(

    @Column(name = "title")
    var title: String,

    @Column(name = "description")
    var description: String? = null,

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime = LocalDateTime.now(),



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
            createdAt = createdAt,
            updatedAt = updatedAt,
        )
    }


