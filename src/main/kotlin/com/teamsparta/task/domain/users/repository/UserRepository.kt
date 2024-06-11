package com.teamsparta.task.domain.users.repository

import com.teamsparta.task.domain.users.model.Users
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<Users, Long> {
}