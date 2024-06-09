package com.teamsparta.task.domain.todo.repository

import com.teamsparta.task.domain.todo.model.Task
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository: JpaRepository<Task, Long> {
}