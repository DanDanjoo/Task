package com.teamsparta.task.domain.user.service

import com.teamsparta.task.domain.user.dto.*

interface UserService {

    fun signup(request: SignUpRequest): UserResponse

    fun login(request: LoginRequest): LoginResponse

    fun updateUserProfile(userId: Long, request: UpdateUserProfileRequest): UserResponse

}