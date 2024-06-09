package com.teamsparta.task.domain.todo.controller


import com.teamsparta.task.domain.todo.dto.CreateTaskRequest
import com.teamsparta.task.domain.todo.dto.TaskResponse
import com.teamsparta.task.domain.todo.dto.UpdateTaskRequest
import com.teamsparta.task.domain.todo.service.TaskServiceImpl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RequestMapping("/todos")
@RestController
class TaskController(private val taskServiceImpl: TaskServiceImpl) {


    @GetMapping
    fun getTasksList(): ResponseEntity<List<TaskResponse>> {
        //TODO
    }

    @GetMapping("/{todoId}")
    fun getTaskById(@PathVariable todoId: Long): ResponseEntity<TaskResponse> {
        //TODO
    }

    @PostMapping
    fun createTask(@RequestBody createTodoRequest: CreateTaskRequest): ResponseEntity<TaskResponse>{

    }

    @PutMapping("/{todoId}")
    fun updateTask(
        @PathVariable todoId: Long,
        @RequestBody updateTodoRequest: UpdateTaskRequest
    ): ResponseEntity<TaskResponse> {
        //TODO
    }

    @DeleteMapping("/{todoId}")
    fun deleteTask(@PathVariable todoId: Long): ResponseEntity<Unit> {
        //TODO
    }




}