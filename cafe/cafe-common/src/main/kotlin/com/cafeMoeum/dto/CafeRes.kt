package com.cafeMoeum.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(name = "카페 정보 DTO", description = "해당 카페의 정보를 제공해줍니다.")
data class CafeRes(
    @Schema(description = "해당 카페의 ID")
    val id: String,
    @Schema(description = "해당 카페의 이름")
    val name: String,
    @Schema(description = "해당 카페의 로고 이미지")
    val img: String,
    @Schema(description = "해당 카페의 base url")
    val url: String
)
