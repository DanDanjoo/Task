package com.teamsparta.task.domain.user.dto

data class SignUpRequest (
    val nickname: String,
    val email: String,
    val password: String
)