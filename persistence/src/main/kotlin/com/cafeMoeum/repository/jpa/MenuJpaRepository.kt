package com.cafeMoeum.repository.jpa

import com.cafeMoeum.entities.Category
import com.cafeMoeum.entities.Menu
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface MenuJpaRepository: JpaRepository<Menu, UUID> {

    fun findAllByCategory(category: Category): List<Menu>

    @Query(
        "select m from menus m " +
                "LEFT JOIN categories c ON m.category " +
                "LEFT JOIN cafes ca ON c.cafe " +
                "WHERE ca.id = :cafeId"
    )
    fun findAllByCafeId(cafeId: String): List<Menu>

    fun deleteByCategory(category: Category)

    fun findByNameKrContaining(keyword: String): List<Menu>
}