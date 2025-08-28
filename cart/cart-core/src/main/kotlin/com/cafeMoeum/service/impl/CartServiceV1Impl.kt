package com.cafeMoeum.service.impl

import com.cafeMoeum.dto.CartRes
import com.cafeMoeum.entities.Cart
import com.cafeMoeum.repository.CafeRepository
import com.cafeMoeum.repository.CartRepository
import com.cafeMoeum.service.CartService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class CartServiceV1Impl(
    private val cartRepository: CartRepository,
    private val cafeRepository: CafeRepository
): CartService {

    override fun createCart(name: String, cafeId: String): CartRes {
        val cafe = try{
            cafeRepository.findById(cafeId)
        }
        catch(e: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "해당 카페가 존재하지 않습니다.")
        }
        return CartRes(cartId = cartRepository.save(Cart(name = name, cafe = cafe)).id)
    }
}