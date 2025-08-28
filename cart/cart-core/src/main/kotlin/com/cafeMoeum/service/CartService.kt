package com.cafeMoeum.service

import com.cafeMoeum.dto.CartRes

interface CartService {

    fun createCart(name: String, cafeId: String): CartRes
}