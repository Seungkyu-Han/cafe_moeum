package com.cafeMoeum.service.impl

import com.cafeMoeum.dto.CafeInfoRes
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

    override fun getCafeInfo(cafeType: String): CafeInfoRes {
        val cafe = cafeRepository.findById(cafeType)

        val categories: List<Category> = categoryRepository.findAllByCafe(cafe = cafe)

        val menus: MutableList<Menu> = mutableListOf()

        categories.forEach { category ->
            menus += menuRepository.findAllByCategory(category)
        }

        return CafeInfoRes(
            categories = categories.map{
                category ->
                category.name
            },
            menus = menus.map{
                menu:Menu ->
                MenuRes(nameKr = menu.nameKr, nameEn = menu.nameEn, img = menu.img)
            }
        )
    }
}