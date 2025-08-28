package com.cafeMoeum.repository.jpa

import com.cafeMoeum.entities.Cart
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CartJpaRepository: JpaRepository<Cart, String> {

    @Query("SELECT c FROM carts c JOIN FETCH c.items WHERE c.id = :id")
    fun findByIdWithItems(id: String): Cart?
}