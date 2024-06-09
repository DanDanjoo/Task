package com.teamsparta.task.domain.user.service

import com.teamsparta.task.domain.user.dto.LoginRequest
import com.teamsparta.task.domain.user.dto.SignUpRequest
import com.teamsparta.task.domain.user.dto.UpdateUserProfileRequest
import com.teamsparta.task.domain.user.dto.UserResponse

interface UserService {

    fun signup(request: SignUpRequest): UserResponse

    fun login(request: LoginRequest): UserResponse

    fun updateUserProfile(userId: Long, request: UpdateUserProfileRequest): UserResponse

}