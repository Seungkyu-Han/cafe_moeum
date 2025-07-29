package com.cafeMoeum.service.impl

import com.cafeMoeum.dto.CafeRes
import com.cafeMoeum.entities.Cafe
import com.cafeMoeum.repository.CafeRepository
import com.cafeMoeum.service.CafeService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class CafeServiceV1Impl(
    private val cafeRepository: CafeRepository
): CafeService {

    @Transactional(readOnly = true)
    override fun findAll(): List<CafeRes> = cafeRepository.findAll().map{it.toResponse()}

    @Transactional
    override fun create(name: String, img: String): CafeRes = cafeRepository.save(Cafe(name = name, img = img)).toResponse()

    @Transactional
    override fun remove(id: UUID) {
        cafeRepository.deleteById(id)
    }

    fun Cafe.toResponse(): CafeRes =
        CafeRes(
            id = this.id,
            name = this.name,
            img = this.img
        )
}