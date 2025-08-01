package com.cafeMoeum.service

import com.cafeMoeum.dto.CategoryMenuRes

interface MenuService {

    fun getCafeInfo(cafeType: String): List<CategoryMenuRes>
}