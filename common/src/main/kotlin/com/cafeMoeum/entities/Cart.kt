package com.cafeMoeum.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.*

@Entity(name = "carts")
data class Cart(
    @Id
    val id: String = UUID.randomUUID().toString(),

    val name: String


    )