package com.cafeMoeum.repository.jpa

import com.cafeMoeum.entities.Cart
import com.cafeMoeum.entities.Item
import org.springframework.data.jpa.repository.JpaRepository

interface ItemJpaRepository: JpaRepository<Item, String> {

    fun deleteByCart(cart: Cart)
}