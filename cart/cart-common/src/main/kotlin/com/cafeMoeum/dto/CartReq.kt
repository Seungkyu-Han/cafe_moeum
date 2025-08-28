package com.cafeMoeum.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "장바구니")
data class CartReq(
    @Schema(description = "장바구니를 생성할 카페의 아이디")
    val cafeId: String,

    @Schema(description = "해당 장바구니의 이름(입력 없으면 ''로 주세요)")
    val name: String,
)
