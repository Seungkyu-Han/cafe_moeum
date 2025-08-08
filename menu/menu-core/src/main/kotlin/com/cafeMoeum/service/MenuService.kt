package com.cafeMoeum.service

import com.cafeMoeum.dto.CategoryMenuRes
import com.cafeMoeum.dto.SearchMenuRes

interface MenuService {

    fun getCafeInfo(cafeType: String): List<CategoryMenuRes>

    fun getSearchMenu(keyword: String): List<SearchMenuRes>

    fun getSearchMenuInCafe(keyword: String, cafeType: String): List<SearchMenuRes>
}