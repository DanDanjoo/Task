package com.teamsparta.task.domain.task.repository

import com.teamsparta.task.domain.task.model.Task
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TaskRepository: JpaRepository<Task, Long> {
    fun findAllByOrderByCreatedAtDesc() : List<Task>
    fun findAllByOrderByCreatedAtAsc() : List<Task>
    fun findAllByUsername(userName: String) : List<Task>

    @Query("select distinct t from Task t left join fetch t.comment")
    fun findAllFetchJPQL(pageable: Pageable) : Page<Task>
}