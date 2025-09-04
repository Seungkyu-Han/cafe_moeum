package com.cafeMoeum.repository.jpa

import com.cafeMoeum.entities.Category
import com.cafeMoeum.entities.Menu
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface MenuJpaRepository: JpaRepository<Menu, UUID> {

    fun findAllByCategory(category: Category): List<Menu>

    @Query("SELECT m FROM menus m JOIN m.category c JOIN c.cafe ca WHERE ca.id = :cafeId")
    fun findAllByCafeId(cafeId: String): List<Menu>

    fun deleteByCategory(category: Category)

    fun findByNameKrContaining(keyword: String): List<Menu>
}