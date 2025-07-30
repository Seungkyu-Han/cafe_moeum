package com.cafeMoeum.repository

import com.cafeMoeum.entities.Cafe

interface CategoryRepository {

    fun deleteByCafe(cafe: Cafe)
}