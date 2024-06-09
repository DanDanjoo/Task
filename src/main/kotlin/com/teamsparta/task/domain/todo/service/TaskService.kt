package com.teamsparta.task.domain.todo.service

import com.teamsparta.task.domain.todo.dto.CreateTaskRequest
import com.teamsparta.task.domain.todo.dto.TaskResponse
import com.teamsparta.task.domain.todo.dto.UpdateTaskRequest


interface TaskService {

    fun getTasksList(): List<TaskResponse>

    fun getTaskById(taskId: Long) : TaskResponse

    fun createTask(request: CreateTaskRequest): TaskResponse

    fun updateTask(taskId: Long, request: UpdateTaskRequest): TaskResponse

    fun deleteTask(taskId: Long)


}

