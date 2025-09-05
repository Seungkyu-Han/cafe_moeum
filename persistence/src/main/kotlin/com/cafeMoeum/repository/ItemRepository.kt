package com.cafeMoeum.repository

import com.cafeMoeum.entities.Cart
import com.cafeMoeum.entities.Item

interface ItemRepository {

    fun deleteByCart(cart: Cart)

    fun saveAll(items: List<Item>)

    fun findAllByCart(cart: Cart): List<Item>
}