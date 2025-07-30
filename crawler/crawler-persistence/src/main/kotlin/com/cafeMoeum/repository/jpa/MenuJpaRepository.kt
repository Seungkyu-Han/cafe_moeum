package com.cafeMoeum.repository.jpa

import com.cafeMoeum.entities.Category

interface MenuJpaRepository {

    fun deleteByCategory(category: Category)
}