package com.teamsparta.task.infra.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around

class TestAop {

    @Around("execution(* com.teamsparta.task.domain.task.service.TaskService.getTaskById(..))")
    fun thisIsAdvice(joinPoint: ProceedingJoinPoint) {
        println("AOP 시작!!")
        joinPoint.proceed()
        println("AOP END!!")

    }
}