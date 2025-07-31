package com.cafeMoeum.dto


data class CategoryRes(
    val category: String,
    val menus: List<MenuRes>,
)
