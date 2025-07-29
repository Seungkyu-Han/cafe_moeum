package com.cafeMoeum.repository.impl

import com.cafeMoeum.entities.Cafe
import com.cafeMoeum.repository.CafeRepository
import com.cafeMoeum.repository.jpa.CafeJpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class CafeRepositoryImpl(
    private val cafeJpaRepository: CafeJpaRepository
): CafeRepository{

    override fun findAll(): List<Cafe> = cafeJpaRepository.findAll()

    override fun save(cafe: Cafe): Cafe = cafeJpaRepository.save(cafe)

    override fun deleteById(id: UUID) {
        cafeJpaRepository.deleteById(id)
    }
}