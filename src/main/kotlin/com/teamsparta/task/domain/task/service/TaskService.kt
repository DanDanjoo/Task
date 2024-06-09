package com.teamsparta.task.domain.task.service

import com.teamsparta.task.domain.task.dto.CreateTaskRequest
import com.teamsparta.task.domain.task.dto.TaskResponse
import com.teamsparta.task.domain.task.dto.UpdateTaskRequest


interface TaskService {

    fun getTasksList(): List<TaskResponse>

    fun getTaskById(taskId: Long) : TaskResponse

    fun createTask(request: CreateTaskRequest): TaskResponse

    fun updateTask(taskId: Long, request: UpdateTaskRequest): TaskResponse

    fun deleteTask(taskId: Long)


}

