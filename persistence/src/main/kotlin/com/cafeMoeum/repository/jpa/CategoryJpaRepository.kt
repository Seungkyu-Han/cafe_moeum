package com.cafeMoeum.repository.jpa

import com.cafeMoeum.entities.Cafe
import com.cafeMoeum.entities.Category
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface CategoryJpaRepository: JpaRepository<Category, UUID> {

    fun findAllByCafe(cafe: Cafe): List<Category>

    fun deleteByCafe(cafe: Cafe)
}