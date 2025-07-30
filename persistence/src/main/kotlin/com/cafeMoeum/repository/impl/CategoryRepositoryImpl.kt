package com.cafeMoeum.repository.impl

import com.cafeMoeum.entities.Cafe
import com.cafeMoeum.repository.CategoryRepository
import com.cafeMoeum.repository.jpa.CategoryJpaRepository
import org.springframework.stereotype.Repository

@Repository
class CategoryRepositoryImpl(
    private val categoryJpaRepository: CategoryJpaRepository
): CategoryRepository {

    override fun deleteByCafe(cafe: Cafe) {
        categoryJpaRepository.deleteByCafe(cafe)
    }
}