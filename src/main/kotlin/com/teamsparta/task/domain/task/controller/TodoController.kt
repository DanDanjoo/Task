package com.teamsparta.task.domain.task.controller


import com.teamsparta.task.domain.task.dto.CreateTaskRequest
import com.teamsparta.task.domain.task.dto.TaskResponse
import com.teamsparta.task.domain.task.dto.UpdateTaskRequest
import com.teamsparta.task.domain.task.service.TaskService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RequestMapping("/taskId")
@RestController
class TaskController(
    private val taskService: TaskService
) {


    @GetMapping
    @Operation(summary = "Task 모두 조회하기", description = "할 일 목록을 조회합니다.")
    fun getTasksList(): ResponseEntity<List<TaskResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(taskService.getTasksList())
    }

    @GetMapping("/{taskId}")
    @Operation(summary = "Task Id로 조회하기", description = "Id로 할 일을 조회합니다.")
    fun getTaskById(@PathVariable taskId: Long): ResponseEntity<TaskResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(taskService.getTaskById(taskId))
    }


    @PostMapping
    @Operation(summary = "Task 만들기", description = "할 일을 생성합니다.")
    fun createTask(@RequestBody createTodoRequest: CreateTaskRequest): ResponseEntity<TaskResponse>{
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(taskService.createTask(createTodoRequest))
    }

    @PutMapping("/{taskId}")
    @Operation(summary = "Task Id로 수정하기", description = "할 일을 수정합니다.")
    fun updateTask(
        @PathVariable taskId: Long,
        @RequestBody updateTodoRequest: UpdateTaskRequest
    ): ResponseEntity<TaskResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(taskService.updateTask(taskId, updateTodoRequest))
    }

    @DeleteMapping("/{taskId}")
    @Operation(summary = "Task Id로 삭제하기", description = "할 일을 삭제합니다.")
    fun deleteTask(@PathVariable taskId: Long): ResponseEntity<Unit> {
        taskService.deleteTask(taskId)
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }
}