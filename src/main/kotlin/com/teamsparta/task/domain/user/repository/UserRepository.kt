package com.teamsparta.task.domain.user.repository

import com.teamsparta.task.domain.user.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {

}