package com.cafeMoeum.repository

import com.cafeMoeum.entities.Cafe

interface CafeRepository {

    fun findAll(): List<Cafe>

    fun save(cafe: Cafe): Cafe

    fun deleteById(id: String)
}