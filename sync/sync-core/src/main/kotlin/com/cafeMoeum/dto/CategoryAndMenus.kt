package com.cafeMoeum.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class CategoryAndMenus(
    @JsonProperty("menuCategories")
    val menuCategories: List<MenuCategory>
)
