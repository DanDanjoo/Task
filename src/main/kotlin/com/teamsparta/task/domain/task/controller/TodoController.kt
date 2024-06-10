package com.teamsparta.task.domain.task.controller


import com.teamsparta.task.domain.task.dto.CommentWithTaskRequest
import com.teamsparta.task.domain.task.dto.CreateTaskRequest
import com.teamsparta.task.domain.task.dto.TaskResponse
import com.teamsparta.task.domain.task.dto.UpdateTaskRequest
import com.teamsparta.task.domain.task.service.TaskService
import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
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
    fun getTasksList(
        @RequestParam sort : String?,
        @RequestParam userName: String?
    ): ResponseEntity<List<TaskResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(taskService.getTasksList(sort, userName))
    }

    @GetMapping("/with-comment")
    @Operation(summary = "Task 모두 조회하기", description = "할 일 목록을 조회합니다.")
    fun getTasksWithCommentList(pageable: Pageable): ResponseEntity<Page<CommentWithTaskRequest>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(taskService.findAllWithComment(pageable))
    }

    @GetMapping("/{taskId}")
    @Operation(summary = "Task Id로 조회하기", description = "할 일을 조회합니다.")
    fun getTaskById(@PathVariable taskId: Long): ResponseEntity<TaskResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(taskService.getTaskById(taskId))
    }


    @PostMapping
    @Operation(summary = "Task 만들기", description = "할 일을 생성합니다.")
    fun createTask(@RequestBody @Valid createTaskRequest: CreateTaskRequest): ResponseEntity<TaskResponse>{
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(taskService.createTask(createTaskRequest))
    }

    @PatchMapping("/{taskId}/complete")
    @Operation(summary = "Task 완료 처리하기", description = "할 일 완료를 체크합니다.")
    fun completeTask(@PathVariable taskId: Long): ResponseEntity<Unit> {

        taskService.completeTask(taskId)

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(null)
    }


    @PutMapping("/{taskId}")
    @Operation(summary = "Task Id로 수정하기", description = "할 일을 수정합니다.")
    fun updateTask(
        @PathVariable taskId: Long,
        @RequestBody @Valid updateTodoRequest: UpdateTaskRequest
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