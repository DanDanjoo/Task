package com.teamsparta.task.domain.todo.service

import com.teamsparta.task.domain.exception.ModelNotFoundException
import com.teamsparta.task.domain.todo.dto.CreateTodoResponse
import com.teamsparta.task.domain.todo.dto.TodoResponse
import com.teamsparta.task.domain.todo.dto.UpdateTodoRequest
import com.teamsparta.task.domain.todo.model.toResponse
import com.teamsparta.task.domain.todo.repository.TodoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TodoServiceImpl(
    private val todoRepository: TodoRepository,
): TodoService {
    override fun getTodosList(): List<TodoResponse> {
        return todoRepository.findAll().map {it.toResponse()}
    }

    override fun getTodoById(todoId: Long): TodoResponse {
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("Todo", todoId)
        return todo.toResponse()
    }

    override fun createTodo(createTodoResponse: CreateTodoResponse): TodoResponse {
        TODO("Not yet implemented")
    }

    override fun updateTodo(updateTodoRequest: UpdateTodoRequest): TodoResponse {
        TODO("Not yet implemented")
    }

    override fun deleteTodo(todoId: Long) {
        TODO("Not yet implemented")
    }
}