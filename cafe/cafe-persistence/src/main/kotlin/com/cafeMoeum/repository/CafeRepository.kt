package com.cafeMoeum.repository

import com.cafeMoeum.entities.Cafe
import java.util.*

interface CafeRepository {

    fun findAll(): List<Cafe>

    fun save(cafe: Cafe): Cafe

    fun deleteById(id: UUID)
}