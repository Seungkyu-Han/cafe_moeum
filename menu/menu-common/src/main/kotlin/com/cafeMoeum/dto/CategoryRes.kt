package com.cafeMoeum.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "카테고리")
data class CategoryRes(
    @Schema(description = "카테고리 명")
    val category: String,
    val menus: List<MenuRes>,
)