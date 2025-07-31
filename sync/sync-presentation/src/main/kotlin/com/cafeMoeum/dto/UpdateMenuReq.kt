package com.cafeMoeum.dto

import com.cafeMoeum.enums.CafeEnum
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

@Schema(name = "카페 메뉴 크롤러 DTO", description = "해당 카페의 메뉴를 크롤링해서 업데이트 해줍니다.")
data class UpdateMenuReq(

    @JsonProperty("cafe")
    @Schema(description = "카페의 종류")
    val cafe: CafeEnum,
)
