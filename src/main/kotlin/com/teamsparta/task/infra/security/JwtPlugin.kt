package com.teamsparta.task.infra.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import java.time.Instant
import java.time.Duration
import java.util.Date

@Component
class JwtPlugin {

    companion object {
        const val ISSUER = "team.sparta.com"
        const val SECRET = "PO5o6c72FN672Fd31967VWbAWq4Ws5aZ"
        const val ACCESS_TOKEN_EXPIRATION_HOUR : Long = 168
    }

    fun validateToken(token: String): Result<Jws<Claims>>{
        return kotlin.runCatching {
           val key = Keys.hmacShaKeyFor(SECRET.toByteArray(StandardCharsets.UTF_8))
            Jwts.parser().verifyWith(key).build().parseClaimsJws(token)
        }
    }


    fun generateAccessToken(subject: String, userName: String): String{
        return generateToken(subject,userName,Duration.ofHours(ACCESS_TOKEN_EXPIRATION_HOUR))
        
    }

    private fun generateToken(subject: String, userName: String, expirationPeriod: Duration?): String {
        val claims: Claims = Jwts.claims()
            .add(mapOf("username" to userName))
            .build()

        val key = Keys.hmacShaKeyFor(SECRET.toByteArray(StandardCharsets.UTF_8))
        val now = Instant.now()

        return Jwts.builder()
            .subject(subject)
            .issuer(ISSUER)
            .issuedAt(Date.from(now))
            .expiration(Date.from(now.plus(expirationPeriod)))
            .claims(claims)
            .signWith(key)
            .compact()
    }
}