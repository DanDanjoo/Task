package com.teamsparta.task.domain.users.service

import com.teamsparta.task.domain.exception.ModelNotFoundException
import com.teamsparta.task.domain.users.dto.CreateUserRequest
import com.teamsparta.task.domain.users.dto.SignInRequest
import com.teamsparta.task.domain.users.dto.UserResponse
import com.teamsparta.task.domain.users.model.Users
import com.teamsparta.task.domain.users.repository.UserRepository
import com.teamsparta.task.infra.security.JwtPlugin
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService (
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtPlugin: JwtPlugin
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

    fun signIn(request: SignInRequest): UserResponse {
        //TODO(로그인 흐름? - 아이디가 존재하는가?)
       val user = userRepository.findByUserName(request.userName) ?: throw Exception("user is not found")
        //TODO(로그인 흐름? - 패스워드가 올바른가?)
        if(user.userName != request.userName ||
                    !passwordEncoder.matches(request.password, user.password)) {
            throw Exception("authentication fail")
        }
        //TODO(로그인 흐름? - 조건을 통과했다면 로그인(토큰발급)
        val token = jwtPlugin.generateAccessToken(
            subject = user.id.toString(),
            userName = user.userName,
        )
        return UserResponse.from(user, token)

    }
}