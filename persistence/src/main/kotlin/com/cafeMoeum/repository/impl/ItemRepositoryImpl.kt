package com.cafeMoeum.repository.impl

import com.cafeMoeum.repository.jpa.ItemJpaRepository
import org.springframework.stereotype.Repository

@Repository
class ItemRepositoryImpl (
    private val itemJpaRepository: ItemJpaRepository
){
}