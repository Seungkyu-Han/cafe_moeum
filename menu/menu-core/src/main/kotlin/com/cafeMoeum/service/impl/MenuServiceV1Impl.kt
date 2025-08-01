package com.cafeMoeum.service.impl

import com.cafeMoeum.dto.CategoryRes
import com.cafeMoeum.dto.MenuRes
import com.cafeMoeum.entities.Category
import com.cafeMoeum.entities.Menu
import com.cafeMoeum.repository.CafeRepository
import com.cafeMoeum.repository.CategoryRepository
import com.cafeMoeum.repository.MenuRepository
import com.cafeMoeum.service.MenuService
import org.springframework.stereotype.Service

@Service
class MenuServiceV1Impl(
    private val cafeRepository: CafeRepository,
    private val categoryRepository: CategoryRepository,
    private val menuRepository: MenuRepository
) : MenuService {

    override fun getCafeInfo(cafeType: String): List<CategoryRes> {
        val cafe = cafeRepository.findById(cafeType)

        val categories: List<Category> = categoryRepository.findAllByCafe(cafe = cafe)

        return categories.map{
                category ->
                CategoryRes(category = category.name, menus = menuRepository.findAllByCategory(category).map{
                        menu -> menu.toDto()
                })
            }
    }

    private fun Menu.toDto(): MenuRes = MenuRes(
        nameKr = this.nameKr,
        nameEn = this.nameEn,
        sortOrder = this.sortOrder,
        img = this.img
    )
}