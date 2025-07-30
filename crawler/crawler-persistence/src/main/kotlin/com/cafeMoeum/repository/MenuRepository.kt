package com.cafeMoeum.repository

import com.cafeMoeum.entities.Category

interface MenuRepository {

    fun deleteByCategory(category: Category)
}