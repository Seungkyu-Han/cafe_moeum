package com.cafeMoeum.dto

import io.swagger.v3.oas.annotations.media.Schema

data class MenuReqDto(

    @Schema(description = "메뉴 아이디")
    val name: String,
    @Schema(description = "메뉴 개수")
    val quantity: Int
)
