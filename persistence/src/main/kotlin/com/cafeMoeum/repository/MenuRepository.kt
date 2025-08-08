package com.cafeMoeum.repository

import com.cafeMoeum.entities.Category
import com.cafeMoeum.entities.Menu

interface MenuRepository {

    fun findAllByCategory(category: Category): List<Menu>

    fun saveAll(menus: List<Menu>): List<Menu>

    fun deleteByCategory(category: Category)

    fun findByNameKrContaining(keyword: String): List<Menu>
}