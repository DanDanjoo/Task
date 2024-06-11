package com.teamsparta.task.domain.users.controller

import com.teamsparta.task.domain.users.dto.CreateUserRequest
import com.teamsparta.task.domain.users.dto.UserResponse
import com.teamsparta.task.domain.users.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/users")
@RestController
class UserController (
    private val userService: UserService
) {


    @PostMapping("/sign-up")
    fun createUser(
        @RequestBody request: CreateUserRequest
    ): ResponseEntity<UserResponse> {
       return ResponseEntity
           .status(HttpStatus.CREATED)
           .body(userService.createUser(request))
    }
}