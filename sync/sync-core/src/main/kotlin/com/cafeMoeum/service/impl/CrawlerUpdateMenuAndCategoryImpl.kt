package com.cafeMoeum.service.impl

import com.cafeMoeum.dto.CategoryAndMenus
import com.cafeMoeum.entities.Cafe
import com.cafeMoeum.entities.Category
import com.cafeMoeum.entities.Menu
import com.cafeMoeum.helper.Crawler
import com.cafeMoeum.repository.CafeRepository
import com.cafeMoeum.repository.CategoryRepository
import com.cafeMoeum.repository.MenuRepository
import com.cafeMoeum.service.UpdateMenuAndCategoryService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Service
class CrawlerUpdateMenuAndCategoryImpl(
    private val crawler: Crawler,
    private val cafeRepository: CafeRepository,
    private val categoryRepository: CategoryRepository,
    private val menuRepository: MenuRepository
): UpdateMenuAndCategoryService {

    @Transactional
    override fun update(cafeType: String) {

        val cafe = cafeRepository.findById(cafeType)

        clearAllMenu(cafe)

        val categoryAndMenus = crawler.getCategoryAndMenu(cafeType) ?: throw RuntimeException()

        inputAllMenu(cafe, categoryAndMenus)
    }

    @Transactional(propagation = Propagation.REQUIRED)
    fun clearAllMenu(cafe: Cafe){
        categoryRepository.findAllByCafe(cafe).forEach {
                category ->
            menuRepository.deleteByCategory(category)
        }

        categoryRepository.deleteByCafe(cafe)
    }

    @Transactional(propagation = Propagation.REQUIRED)
    fun inputAllMenu(cafe: Cafe, categoryAndMenus: CategoryAndMenus){
        categoryAndMenus.menuCategories.forEach {
            categoryAndMenu ->
            val category = categoryRepository.save(Category(name = categoryAndMenu.category.name, cafe = cafe, sortOrder = categoryAndMenu.category.order))

            menuRepository.saveAll(categoryAndMenu.menus.map{ menu ->
                Menu(nameEn = menu.nameEn, nameKr = menu.nameKr, img = menu.img, category = category, sortOrder = menu.order)
            })
        }
    }
}