package com.cafeMoeum.service.impl

import com.cafeMoeum.dto.CategoryMenuRes
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

    override fun getCafeInfo(cafeType: String): List<CategoryMenuRes> {
        val cafe = cafeRepository.findById(cafeType)

        val categories: List<Category> = categoryRepository.findAllByCafe(cafe = cafe)

        return categories.map{
                category ->
                CategoryMenuRes(category = CategoryRes(name = category.name, sortOrder = category.sortOrder), menus = menuRepository.findAllByCategory(category).map{
                        menu -> menu.toDto()
                })
            }
    }

    override fun getSearchMenu(keyword: String): List<CategoryMenuRes> {
        return menuRepository.findByNameKrContaining(keyword).groupBy {
            it.category
        }.mapKeys{
            entry -> CategoryRes(name = entry.key.name, sortOrder = entry.key.sortOrder)
        }.mapValues {
            entry -> entry.value.map{
                it.toDto()
            }
        }.map{
            CategoryMenuRes(category = it.key, menus = it.value)
        }
    }

    override fun getSearchMenuInCafe(keyword: String, cafeType: String): List<CategoryMenuRes>{
        return menuRepository.findByNameKrContainingAndCafe(keyword, cafeType)
            .groupBy {
                it.category
            }.mapKeys{
                entry -> CategoryRes(name = entry.key.name, sortOrder = entry.key.sortOrder)
            }.mapValues {
                entry -> entry.value.map{
                    it.toDto()
                }
            }.map{
                CategoryMenuRes(category = it.key, menus = it.value)
            }
    }

    private fun Menu.toDto(): MenuRes = MenuRes(
        nameKr = this.nameKr,
        nameEn = this.nameEn,
        sortOrder = this.sortOrder,
        img = this.img
    )
}