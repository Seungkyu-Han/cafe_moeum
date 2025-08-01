package com.cafeMoeum.service

import com.cafeMoeum.dto.CategoryRes

interface MenuService {

    fun getCafeInfo(cafeType: String): List<CategoryRes>
}