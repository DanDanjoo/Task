package com.teamsparta.task.domain.todo.controller


import com.teamsparta.task.domain.todo.dto.CreateTodoResponse
import com.teamsparta.task.domain.todo.dto.TodoResponse
import com.teamsparta.task.domain.todo.dto.UpdateTodoRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/todos")
@RestController
class TodoController {


    @GetMapping
    fun getTodosList(): ResponseEntity<List<TodoResponse>> {
        //TODO
    }

    @GetMapping("/{todoId}")
    fun getTodoById(@PathVariable todoId: Long): ResponseEntity<TodoResponse> {
        //TODO
    }

    @PostMapping
    fun createTodo(@RequestBody createTodoResponse: CreateTodoResponse): ResponseEntity<TodoResponse>{

    }

    @PutMapping("/{todoId}")
    fun updateTodo(
        @PathVariable todoId: Long,
        @RequestBody updateTodoRequest: UpdateTodoRequest
    ): ResponseEntity<TodoResponse> {
        //TODO
    }

    @DeleteMapping("/{todoId}")
    fun deleteTodo(@PathVariable todoId: Long): ResponseEntity<Unit> {
        //TODO
    }




}