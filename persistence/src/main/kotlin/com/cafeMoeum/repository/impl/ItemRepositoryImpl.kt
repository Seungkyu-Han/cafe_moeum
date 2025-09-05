package com.cafeMoeum.repository.impl

import com.cafeMoeum.entities.Cart
import com.cafeMoeum.entities.Item
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

    override fun saveAll(items: List<Item>) {
        itemJpaRepository.saveAll(items)
    }

    override fun findAllByCart(cart: Cart): List<Item> {
        return itemJpaRepository.findAllByCart(cart)
    }
}