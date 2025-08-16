package com.cafeMoeum.service

import com.cafeMoeum.dto.HitCountRes

interface HitReadService {

    fun getHitCount(): HitCountRes
}