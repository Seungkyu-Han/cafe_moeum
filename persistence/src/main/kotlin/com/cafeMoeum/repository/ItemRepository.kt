package com.cafeMoeum.repository

import com.cafeMoeum.entities.Cart

interface ItemRepository {

    fun deleteByCart(cart: Cart)
}