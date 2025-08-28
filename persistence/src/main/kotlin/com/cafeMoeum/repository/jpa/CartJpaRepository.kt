package com.cafeMoeum.repository.jpa

import com.cafeMoeum.entities.Cart
import org.springframework.data.jpa.repository.JpaRepository

interface CartJpaRepository: JpaRepository<Cart, String> {
}