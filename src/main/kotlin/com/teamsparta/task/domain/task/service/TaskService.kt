package com.teamsparta.task.domain.task.service

import com.teamsparta.task.domain.task.comment.dto.AddCommentRequest
import com.teamsparta.task.domain.task.comment.dto.CommentResponse
import com.teamsparta.task.domain.task.comment.dto.UpdateCommentRequest
import com.teamsparta.task.domain.task.dto.CreateTaskRequest
import com.teamsparta.task.domain.task.comment.dto.RemoveCommentRequest
import com.teamsparta.task.domain.task.dto.TaskResponse
import com.teamsparta.task.domain.task.dto.UpdateTaskRequest


interface TaskService {

    fun getTasksList(sort : String?, userName : String?): List<TaskResponse>

    fun getTaskById(taskId: Long) : TaskResponse

    fun createTask(request: CreateTaskRequest): TaskResponse

    fun updateTask(taskId: Long, request: UpdateTaskRequest): TaskResponse

    fun deleteTask(taskId: Long)

    fun completeTask(taskId: Long)

    fun getCommentList(taskId: Long): List<CommentResponse>

    fun addComment(taskId: Long, request : AddCommentRequest): CommentResponse

    fun updateComment(taskId: Long, commentId: Long, request : UpdateCommentRequest): CommentResponse

    fun removeComment(taskId: Long, commentId: Long, request: RemoveCommentRequest)

}

