package com.cafeMoeum.repository.impl

import com.cafeMoeum.entities.Cart
import com.cafeMoeum.repository.ItemRepository
import com.cafeMoeum.repository.jpa.ItemJpaRepository
import org.springframework.stereotype.Repository

@Repository
class ItemRepositoryImpl (
    private val itemJpaRepository: ItemJpaRepository
): ItemRepository {

    override fun deleteByCart(cart: Cart) {
        itemJpaRepository.deleteByCart(cart)
    }
}