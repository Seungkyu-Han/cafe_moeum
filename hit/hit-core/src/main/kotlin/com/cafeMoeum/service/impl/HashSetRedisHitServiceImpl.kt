package com.cafeMoeum.service.impl

import com.cafeMoeum.service.HitReadService
import com.cafeMoeum.service.HitRecordService
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Component

@Component
class HashSetRedisHitServiceImpl(
    private val redisTemplate: StringRedisTemplate
): HitReadService, HitRecordService {

    private val todayHitKey = "HIT:TODAY"
    private val totalHitKey = "HIT:TOTAL"
    private val todayHitUserHashSet = HashSet<String>()

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {

        val clientIp = getClientIp(request)

        if(!todayHitUserHashSet.contains(clientIp)){
            todayHitUserHashSet.add(clientIp)
            redisTemplate.opsForValue().increment(todayHitKey, 1)
        }

        return super.preHandle(request, response, handler)
    }

    private fun getClientIp(request: HttpServletRequest): String {
        val header = request.getHeader("X-Forwarded-For")
        if (!header.isNullOrEmpty()) {
            return header.split(",").first().trim()
        }
        return request.remoteAddr
    }
}