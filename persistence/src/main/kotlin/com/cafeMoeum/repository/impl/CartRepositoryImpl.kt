package com.cafeMoeum.repository.impl

import com.cafeMoeum.entities.Cart
import com.cafeMoeum.repository.CartRepository
import com.cafeMoeum.repository.jpa.CartJpaRepository
import org.springframework.stereotype.Repository

@Repository
class CartRepositoryImpl(
    private val cartJpaRepository: CartJpaRepository
) : CartRepository {

    override fun save(cart: Cart): Cart {
        return cartJpaRepository.save(cart)
    }

    override fun findById(id: String): Cart {
        return cartJpaRepository.findById(id).orElseThrow()
    }
}