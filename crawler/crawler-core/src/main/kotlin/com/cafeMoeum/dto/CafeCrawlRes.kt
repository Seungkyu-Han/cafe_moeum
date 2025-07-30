package com.cafeMoeum.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class CafeCrawlRes(
    @JsonProperty("menuCategories")
    val menuCategories: List<MenuCategory>
)
