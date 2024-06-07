package com.teamsparta.task.domain.todo.service

import com.teamsparta.task.domain.todo.dto.CreateTodoResponse
import com.teamsparta.task.domain.todo.dto.TodoResponse
import com.teamsparta.task.domain.todo.dto.UpdateTodoRequest
import org.springframework.stereotype.Service

@Service
class TodoServiceImpl(): TodoService {
    override fun getTodosList(): List<TodoResponse> {
        TODO("Not yet implemented")
    }

    override fun getTodoById(todoId: Long): TodoResponse {
        TODO("Not yet implemented")
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