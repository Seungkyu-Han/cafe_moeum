package com.cafeMoeum.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "카테고리")
data class CategoryRes(
    @Schema(description = "카테고리 명")
    val name: String,
    @Schema(description = "카테고리 정렬 순서")
    val sortOrder: Int
)