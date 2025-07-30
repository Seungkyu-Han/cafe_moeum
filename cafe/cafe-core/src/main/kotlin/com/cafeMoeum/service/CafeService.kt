package com.cafeMoeum.service

import com.cafeMoeum.dto.CafeRes

interface CafeService {

    fun findAll(): List<CafeRes>
}