package com.teamsparta.task.domain.user.service


import com.teamsparta.task.domain.user.dto.*
import com.teamsparta.task.domain.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
): UserService {

    override fun signup(request: SignUpRequest): UserResponse {
        TODO("Not yet implemented")
    }

    override fun login(request: LoginRequest): LoginResponse {
        TODO("Not yet implemented")
    }

    override fun updateUserProfile(userId: Long, request: UpdateUserProfileRequest): UserResponse {
        TODO("Not yet implemented")
    }

}