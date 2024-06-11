package com.teamsparta.task.domain.users.dto

import com.teamsparta.task.domain.users.model.Users

data class UserResponse (
    val id : Long?,
    val username : String
) {
    companion object {
        fun from(saveUser: Users): UserResponse {

            return UserResponse(
                saveUser.id,
                saveUser.userName
            )
        }
    }
}
