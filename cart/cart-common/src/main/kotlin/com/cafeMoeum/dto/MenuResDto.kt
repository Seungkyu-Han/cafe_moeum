package com.cafeMoeum.dto

import java.util.UUID

data class MenuResDto(
    val id: UUID,
    val nameKr: String,
    val nameEn: String,
    val img: String,
    val quantity: Int,
)
