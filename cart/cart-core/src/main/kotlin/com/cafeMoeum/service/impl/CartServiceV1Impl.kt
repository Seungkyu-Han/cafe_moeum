package com.cafeMoeum.service.impl

import com.cafeMoeum.dto.CartRes
import com.cafeMoeum.dto.MenuBoardReqDto
import com.cafeMoeum.dto.MenuBoardResDto
import com.cafeMoeum.dto.MenuResDto
import com.cafeMoeum.entities.Cart
import com.cafeMoeum.entities.Item
import com.cafeMoeum.entities.Menu
import com.cafeMoeum.repository.CafeRepository
import com.cafeMoeum.repository.CartRepository
import com.cafeMoeum.repository.ItemRepository
import com.cafeMoeum.repository.MenuRepository
import com.cafeMoeum.service.CartService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException
import java.util.UUID
import java.util.concurrent.CompletableFuture

@Service
class CartServiceV1Impl(
    private val cartRepository: CartRepository,
    private val cafeRepository: CafeRepository,
    private val itemRepository: ItemRepository,
    private val menuRepository: MenuRepository
): CartService {

    override fun createCart(name: String, cafeId: String): CartRes {
        val cafe = try{
            cafeRepository.findById(cafeId)
        }
        catch(_: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "해당 카페가 존재하지 않습니다.")
        }
        return CartRes(cartId = cartRepository.save(Cart(name = name, cafe = cafe)).id)
    }

    @Transactional
    override fun updateCart(menuBoardReqDto: MenuBoardReqDto, cartId: String): MenuBoardResDto {
        val cart = cartRepository.findById(cartId)

        itemRepository.deleteByCart(cart)

        val menuMap = hashMapOf<UUID, Menu>()

        menuRepository.findAllByCafeId(cart.cafe.id)
            .forEach { menu -> menuMap.put(menu.id, menu) }

        val menuResDtoList = mutableListOf<MenuResDto>()

        val itemEntities = mutableListOf<Item>()

        menuBoardReqDto.menus.forEach {
            menu ->
            val curMenu = menuMap[menu.id] ?: throw NullPointerException()
            menuResDtoList.add(MenuResDto(
                id = curMenu.id.toString(),
                nameKr = curMenu.nameKr,
                nameEn = curMenu.nameEn,
                img = curMenu.img,
                quantity = menu.quantity,
            ))

            itemEntities.add(Item(cart = cart, menu = curMenu, count = menu.quantity))
        }

        CompletableFuture.runAsync {
            itemRepository.saveAll(itemEntities)
        }



        return MenuBoardResDto(menus = menuResDtoList)
    }

    override fun getCart(cartId: String): MenuBoardResDto {
        val cart = cartRepository.findById(cartId)

        val items = itemRepository.findAllByCart(cart)

        return MenuBoardResDto(menus =
            items.map{ item ->
                MenuResDto(item.id, item.menu.nameKr, item.menu.nameEn, item.menu.img, item.count)
            }
        )
    }
}