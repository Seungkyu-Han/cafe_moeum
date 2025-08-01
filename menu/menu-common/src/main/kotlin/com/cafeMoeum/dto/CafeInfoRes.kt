package com.cafeMoeum.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(name = "카페 메뉴 및 카테고리 응답 DTO", description = "해당 카페의 메뉴 및 카테고리를 조회해줍니다.")
data class CafeInfoRes(

    val categories: List<CategoryRes>
)
