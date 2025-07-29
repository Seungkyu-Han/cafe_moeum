package com.cafeMoeum.service

import com.cafeMoeum.dto.CafeRes
import java.util.UUID

interface CafeService {

    fun findAll(): List<CafeRes>

    fun create(name: String, img: String): CafeRes

    fun remove(id: UUID)
}