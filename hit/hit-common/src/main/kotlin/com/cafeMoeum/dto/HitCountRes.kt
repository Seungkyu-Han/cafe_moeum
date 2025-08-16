package com.cafeMoeum.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "조회수")
data class HitCountRes(
    @Schema(description = "오늘의 방문자 수")
    val todayHit: Long,

    @Schema(description = "총 방문자 수")
    val totalHit: Long
)
