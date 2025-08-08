package com.cafeMoeum.repository.impl

import com.cafeMoeum.entities.Category
import com.cafeMoeum.entities.Menu
import com.cafeMoeum.repository.MenuRepository
import com.cafeMoeum.repository.jpa.MenuJpaRepository
import org.springframework.stereotype.Repository

@Repository
class MenuRepositoryImpl(
    private val menuJpaRepository: MenuJpaRepository
): MenuRepository {

    override fun findAllByCategory(category: Category): List<Menu> = menuJpaRepository.findAllByCategory(category)

    override fun saveAll(menus: List<Menu>): List<Menu> = menuJpaRepository.saveAll(menus)

    override fun deleteByCategory(category: Category) {
        menuJpaRepository.deleteByCategory(category)
    }

    override fun findByNameKrContaining(keyword: String): List<Menu> = menuJpaRepository.findByNameKrContaining(keyword)
}