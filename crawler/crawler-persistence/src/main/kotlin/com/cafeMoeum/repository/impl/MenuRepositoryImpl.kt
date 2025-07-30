package com.cafeMoeum.repository.impl

import com.cafeMoeum.entities.Category
import com.cafeMoeum.repository.MenuRepository
import com.cafeMoeum.repository.jpa.MenuJpaRepository
import org.springframework.stereotype.Repository

@Repository
class MenuRepositoryImpl(
    private val menuJpaRepository: MenuJpaRepository
): MenuRepository {

    override fun deleteByCategory(category: Category) {
        menuJpaRepository.deleteByCategory(category)
    }
}