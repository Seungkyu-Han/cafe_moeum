package com.cafeMoeum.repository.impl

import com.cafeMoeum.repository.jpa.CartJpaRepository
import org.springframework.stereotype.Repository

@Repository
class CartRepositoryImpl(
    private val cartJpaRepository: CartJpaRepository
) {
}