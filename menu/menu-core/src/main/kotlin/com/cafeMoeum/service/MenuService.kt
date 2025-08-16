package com.cafeMoeum.service

import com.cafeMoeum.dto.CategoryMenuRes

interface MenuService {

    fun getCafeInfo(cafeType: String): List<CategoryMenuRes>

    fun getSearchMenu(keyword: String): List<CategoryMenuRes>

    fun getSearchMenuInCafe(keyword: String, cafeType: String): List<CategoryMenuRes>
}