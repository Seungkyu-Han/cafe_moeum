package com.cafeMoeum.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.util.UUID

data class MenuReqDto(

    @Schema(description = "메뉴 아이디")
    val id: UUID,
    @Schema(description = "메뉴 개수")
    val quantity: Int
)
