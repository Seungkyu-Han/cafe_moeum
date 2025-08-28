package com.cafeMoeum.entities

import jakarta.persistence.*
import java.util.*

@Entity(name = "carts")
data class Cart(
    @Id
    val id: String = UUID.randomUUID().toString(),

    @ManyToOne
    val cafe: Cafe,

    val name: String,

    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true)
    val items: MutableList<Item> = mutableListOf(),

    val createdAt: Date = Date(),
)