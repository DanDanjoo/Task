package com.teamsparta.task.domain.task.repository

import com.teamsparta.task.domain.task.model.Task
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository: JpaRepository<Task, Long> {
}