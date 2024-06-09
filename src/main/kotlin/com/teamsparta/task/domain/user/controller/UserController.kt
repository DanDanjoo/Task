package com.teamsparta.task.domain.user.controller

import com.teamsparta.task.domain.user.dto.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class UserController {

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<LoginResponse> {
        //TODO
    }

    @PostMapping("/signup")
    fun signUp(@RequestBody request: SignUpRequest): ResponseEntity<UserResponse> {
        //TODO

    }

    @PutMapping("/user/{userId}/profile")
    fun updateUserProfile(
        @PathVariable userId: Long,
        @RequestBody request: UpdateUserProfileRequest
    ): ResponseEntity<UserResponse>{
        //TODO
    }
}