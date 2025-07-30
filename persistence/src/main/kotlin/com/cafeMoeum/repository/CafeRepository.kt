package com.cafeMoeum.repository

import com.cafeMoeum.entities.Cafe

interface CafeRepository {
    fun findAll(): List<Cafe>

    fun findById(id: String): Cafe
}