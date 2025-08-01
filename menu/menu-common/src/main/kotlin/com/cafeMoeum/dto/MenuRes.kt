package com.cafeMoeum.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "카테고리")
data class MenuRes(

    @Schema(description = "메뉴 한글 명")
    val nameKr: String,

    @Schema(description = "메뉴 영문 명")
    val nameEn: String,

    @Schema(description = "메뉴 정렬 순서")
    val sortOrder: Int,

    @Schema(description = "메뉴 이미지")
    val img: String
)
