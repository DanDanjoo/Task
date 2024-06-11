package com.teamsparta.task.domain.users.service

import com.teamsparta.task.domain.users.dto.CreateUserRequest
import com.teamsparta.task.domain.users.dto.UserResponse
import com.teamsparta.task.domain.users.model.Users
import com.teamsparta.task.domain.users.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService (
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {

    @Transactional
    fun createUser(request: CreateUserRequest): UserResponse {
        val user = Users(
            request.userName,
            passwordEncoder.encode(request.password)
        )

        val saveUser = userRepository.save(user)

        return UserResponse.from(saveUser)

    }
}