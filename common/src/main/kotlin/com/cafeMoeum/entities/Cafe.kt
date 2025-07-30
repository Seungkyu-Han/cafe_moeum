package com.cafeMoeum.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "cafes")
data class Cafe(
    @Id
    val id: String,


    val name: String,

    val img: String
)
