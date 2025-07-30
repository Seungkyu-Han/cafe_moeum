package com.cafeMoeum.repository

import com.cafeMoeum.entities.Cafe
import com.cafeMoeum.entities.Category

interface CategoryRepository {

    fun save(category: Category): Category

    fun findAllByCafe(cafe: Cafe): List<Category>

    fun deleteByCafe(cafe: Cafe)
}