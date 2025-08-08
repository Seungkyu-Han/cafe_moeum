package com.cafeMoeum.repository.jpa

import com.cafeMoeum.entities.Category
import com.cafeMoeum.entities.Menu
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface MenuJpaRepository: JpaRepository<Menu, UUID> {

    fun findAllByCategory(category: Category): List<Menu>

    fun deleteByCategory(category: Category)

    fun findByNameKrContaining(keyword: String): List<Menu>
}