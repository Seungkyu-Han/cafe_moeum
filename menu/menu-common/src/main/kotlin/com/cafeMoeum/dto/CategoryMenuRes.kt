package com.cafeMoeum.dto

import io.swagger.v3.oas.annotations.media.Schema

data class CategoryMenuRes(
    @Schema(description = "카테고리")
    val category: CategoryRes,
    @Schema(description = "메뉴 리스트")
    val menus: List<MenuRes>,
)
