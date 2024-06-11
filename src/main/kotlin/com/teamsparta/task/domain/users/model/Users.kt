package com.teamsparta.task.domain.users.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity
class Users(
    @Column
    var userName: String,

    @Column
    var password: String,

)

{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null
}