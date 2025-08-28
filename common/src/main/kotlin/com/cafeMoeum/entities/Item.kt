package com.cafeMoeum.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.util.*

@Entity(name = "items")
data class Item(
    @Id
    val id: String = UUID.randomUUID().toString(),

    @ManyToOne
    val cart: Cart,

    @ManyToOne
    val menu: Menu,

    val count: Int
)
