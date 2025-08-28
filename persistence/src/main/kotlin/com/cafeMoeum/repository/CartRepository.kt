package com.cafeMoeum.repository

import com.cafeMoeum.entities.Cart

interface CartRepository {
    fun save(cart: Cart): Cart
}