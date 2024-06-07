package com.teamsparta.task.domain.todo.repository

import com.teamsparta.task.domain.todo.model.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository: JpaRepository<Todo, Long> {
}