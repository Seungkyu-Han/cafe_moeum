package com.cafeMoeum.repository.jpa

import com.cafeMoeum.entities.Cafe

interface CategoryJpaRepository {

    fun deleteByCafe(cafe: Cafe)
}