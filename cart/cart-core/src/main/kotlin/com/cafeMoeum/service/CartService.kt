package com.cafeMoeum.service

import com.cafeMoeum.dto.CartRes
import com.cafeMoeum.dto.MenuBoardReqDto
import com.cafeMoeum.dto.MenuBoardResDto

interface CartService {

    fun createCart(name: String, cafeId: String): CartRes

    fun updateCart(menuBoardReqDto: MenuBoardReqDto, cartId: String): MenuBoardResDto
}