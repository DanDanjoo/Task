package com.teamsparta.task.domain.user.controller

import com.teamsparta.task.domain.user.dto.*
import com.teamsparta.task.domain.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class UserController(
    private val userService: UserService,
) {

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<LoginResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(userService.login(request))
    }

    @PostMapping("/signup")
    fun signUp(@RequestBody request: SignUpRequest): ResponseEntity<UserResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(userService.signup(request))

    }

    @PutMapping("/user/{userId}/profile")
    fun updateUserProfile(
        @PathVariable userId: Long,
        @RequestBody request: UpdateUserProfileRequest
    ): ResponseEntity<UserResponse>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(userService.updateUserProfile(userId, request))
    }
}