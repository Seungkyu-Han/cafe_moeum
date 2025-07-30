package com.cafeMoeum.repository

import com.cafeMoeum.entities.Category
import com.cafeMoeum.entities.Menu

interface MenuRepository {

    fun saveAll(menus: List<Menu>): List<Menu>

    fun deleteByCategory(category: Category)
}