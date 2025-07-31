package com.cafeMoeum.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.util.*

@Entity(name = "menus")
data class Menu(
    @Id
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID(),

    val nameKr: String,

    val nameEn: String,

    val img: String,

    val order: Int,

    @ManyToOne
    val category: Category
)