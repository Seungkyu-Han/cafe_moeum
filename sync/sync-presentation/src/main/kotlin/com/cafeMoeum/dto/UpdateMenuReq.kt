package com.cafeMoeum.dto

import com.cafeMoeum.enums.CafeEnum
import com.fasterxml.jackson.annotation.JsonProperty

data class UpdateMenuReq(
    @JsonProperty("cafe")
    val cafe: CafeEnum,
)
