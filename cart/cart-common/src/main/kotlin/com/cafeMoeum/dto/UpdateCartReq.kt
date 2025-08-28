package com.cafeMoeum.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "장바구니 업데이트")
data class UpdateCartReq(
    @Schema(description = "닫을 장바구니의 아이디")
    val cartId: String,
)
