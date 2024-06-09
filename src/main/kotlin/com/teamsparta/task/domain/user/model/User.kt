package com.teamsparta.task.domain.user.model

import com.teamsparta.task.domain.user.dto.UserResponse
import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
@Table(name = "users")
class User (

    @Embedded
    var profile: Profile,

    @Column(name = "email", nullable = false)
    val email : String,

    @Column(name = "password", nullable = false)
    val password: String,

    @Column(name = "createdAt", nullable = false)
    val createdAt : LocalDateTime,

    @Column(name = "updatedAt", nullable = false)
    var updatedAt : LocalDateTime
){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null
}

fun User.toResponse(): UserResponse {
    return UserResponse(
        id = id!!,
        nickname = profile.nickname,
        email = email,
    )
}