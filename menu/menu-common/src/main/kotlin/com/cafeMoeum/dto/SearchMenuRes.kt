package com.cafeMoeum.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "메뉴 검색 결과", name = "메뉴 검색 결과")
data class SearchMenuRes(

    @Schema(description = "카페 이름")
    val cafeName: String,

    @Schema(description = "카테고리 이름")
    val categoryName: String,

    @Schema(description = "이름")
    val nameKr: String,

    @Schema(description = "영어 이름")
    val nameEn: String,

    @Schema(description = "이미지 주소")
    val img: String,
)
