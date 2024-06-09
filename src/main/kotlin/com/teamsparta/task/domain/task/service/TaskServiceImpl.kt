package com.teamsparta.task.domain.task.service

import com.teamsparta.task.domain.exception.ModelNotFoundException
import com.teamsparta.task.domain.task.comment.dto.AddCommentRequest
import com.teamsparta.task.domain.task.comment.dto.CommentResponse
import com.teamsparta.task.domain.task.comment.dto.UpdateCommentRequest
import com.teamsparta.task.domain.task.comment.model.Comment
import com.teamsparta.task.domain.task.comment.model.toResponse
import com.teamsparta.task.domain.task.comment.repository.CommentRepository
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
    private val commentRepository: CommentRepository,
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

    override fun getCommentList(taskId: Long): List<CommentResponse> {
        taskRepository.findByIdOrNull(taskId) ?: throw ModelNotFoundException("Task", taskId)

        return commentRepository.findAllbyTaskId(taskId).sortedBy { it.createdAt }.map {it.toResponse()}
    }
    @Transactional
    override fun addComment(taskId: Long, request: AddCommentRequest): CommentResponse {
        val task = taskRepository.findByIdOrNull(taskId) ?: throw ModelNotFoundException("Task", taskId)

        val comment = Comment(
            content = request.content,
            task = task
        )
        return commentRepository.save(comment).toResponse()
    }

    @Transactional
    override fun updateComment(taskId: Long, commentId: Long, request: UpdateCommentRequest): CommentResponse {
        val task = taskRepository.findByIdOrNull(taskId) ?: throw ModelNotFoundException("Task", taskId)
        val comment = commentRepository.findByTaskIdAndId(taskId, commentId) ?: throw ModelNotFoundException("Comment", commentId)

        return commentRepository.save(comment).toResponse()
    }

    @Transactional
    override fun removeComment(taskId: Long, commentId: Long) {
        val task = taskRepository.findByIdOrNull(taskId) ?: throw ModelNotFoundException("Task", taskId)
        val comment = commentRepository.findByTaskIdAndId(taskId, commentId) ?: throw ModelNotFoundException("Comment", commentId)

        commentRepository.delete(comment)
    }
}