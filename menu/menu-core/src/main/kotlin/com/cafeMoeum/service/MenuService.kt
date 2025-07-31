package com.cafeMoeum.service

import com.cafeMoeum.dto.CafeInfoRes

interface MenuService {

    fun getCafeInfo(cafeType: String): CafeInfoRes
}