package com.teamsparta.task.domain.users.dto

import com.teamsparta.task.domain.users.model.Users

data class UserResponse (
    val id : Long?,
    val username : String
) {

    var token : String? = null

    companion object {
        fun from(saveUser: Users): UserResponse {

            return UserResponse(
                saveUser.id,
                saveUser.userName
            )
        }

        fun from(saveUser: Users, token : String): UserResponse {
            val userResponse = UserResponse(
                saveUser.id,
                saveUser.userName
            )
            userResponse.token = token

            return userResponse
        }
    }

}
