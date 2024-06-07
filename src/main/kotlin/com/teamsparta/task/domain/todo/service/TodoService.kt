package com.teamsparta.task.domain.todo.service

import com.teamsparta.task.domain.todo.dto.CreateTodoResponse
import com.teamsparta.task.domain.todo.dto.TodoResponse
import com.teamsparta.task.domain.todo.dto.UpdateTodoRequest


interface TodoService {

    fun getTodosList(): List<TodoResponse>

    fun getTodoById(todoId: Long) : TodoResponse

    fun createTodo(createTodoResponse: CreateTodoResponse): TodoResponse

    fun updateTodo(updateTodoRequest: UpdateTodoRequest): TodoResponse

    fun deleteTodo(todoId: Long)


}

