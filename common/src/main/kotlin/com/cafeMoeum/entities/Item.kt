package com.cafeMoeum.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Index
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.util.*

@Entity(name = "items")
@Table(indexes = [
    Index(name = "idx__cart", columnList = "cart"),
])
data class Item(
    @Id
    val id: String = UUID.randomUUID().toString(),

    @ManyToOne
    val cart: Cart,

    @ManyToOne
    val menu: Menu,

    val count: Int
)
