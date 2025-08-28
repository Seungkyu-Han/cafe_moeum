package com.cafeMoeum.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "생성된 장바구니")
data class CartRes(
    @Schema(description = "생성된 장바구니의 아이디입니다.")
    val cartId: String,
)
