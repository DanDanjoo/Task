package com.teamsparta.task.domain.task.service

import com.teamsparta.task.domain.exception.ModelNotFoundException
import com.teamsparta.task.domain.task.dto.CreateTaskRequest
import com.teamsparta.task.domain.task.dto.TaskResponse
import com.teamsparta.task.domain.task.dto.UpdateTaskRequest
import com.teamsparta.task.domain.task.model.Task
import com.teamsparta.task.domain.task.model.toResponse
import com.teamsparta.task.domain.task.repository.TaskRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TaskServiceImpl(
    private val taskRepository: TaskRepository,
): TaskService {

    override fun getTasksList(): List<TaskResponse> {
        return taskRepository.findAll().map {it.toResponse()}
    }

    override fun getTaskById(taskId: Long): TaskResponse {
        val task = taskRepository.findByIdOrNull(taskId) ?: throw ModelNotFoundException("Task", taskId)


        return task.toResponse()
    }

    @Transactional
    override fun createTask(request: CreateTaskRequest): TaskResponse {
        val task = Task(
            title = request.title,
            description = request.description,

            )

        return taskRepository.save(task).toResponse()
    }

    @Transactional
    override fun updateTask(taskId: Long, request: UpdateTaskRequest): TaskResponse {
        val task = taskRepository.findByIdOrNull(taskId) ?: throw ModelNotFoundException("Task", taskId)

        task.title = request.title
        task.description = request.description


        return task.toResponse()
    }

    @Transactional
    override fun deleteTask(taskId: Long) {
        val task = taskRepository.findByIdOrNull(taskId) ?: throw ModelNotFoundException("Task", taskId)
        taskRepository.delete(task)
    }
}