package com.cafeMoeum.service.impl

import com.cafeMoeum.dto.HitCountRes
import com.cafeMoeum.service.HitReadService
import com.cafeMoeum.service.HitRecordService
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

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

    override fun getHitCount(): HitCountRes {
        val todayHitCount = redisTemplate.opsForValue().get(todayHitKey)?.toLong() ?: 0
        val totalHitCount = redisTemplate.opsForValue().get(totalHitKey)?.toLong() ?: 0

        return HitCountRes(
            todayHit = todayHitCount,
            totalHit = totalHitCount + todayHitCount
        )
    }

    @Scheduled(cron = "0 0 0 * * ?")
    @Transactional
    fun flushTodayHitCount(){
        val todayHitCount = redisTemplate.opsForValue().get(todayHitKey)?.toLong()

        if (todayHitCount != null) {
            redisTemplate.opsForValue().increment(totalHitKey, todayHitCount)
        }

        todayHitUserHashSet.clear()
        redisTemplate.opsForValue().set(todayHitKey, "0")
    }

    private fun getClientIp(request: HttpServletRequest): String {
        val header = request.getHeader("X-Forwarded-For")
        if (!header.isNullOrEmpty()) {
            return header.split(",").first().trim()
        }
        return request.remoteAddr
    }
}