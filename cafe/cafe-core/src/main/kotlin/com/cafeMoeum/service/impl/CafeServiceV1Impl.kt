package com.cafeMoeum.service.impl

import com.cafeMoeum.dto.CafeRes
import com.cafeMoeum.entities.Cafe
import com.cafeMoeum.repository.CafeRepository
import com.cafeMoeum.service.CafeService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CafeServiceV1Impl(
    private val cafeRepository: CafeRepository
): CafeService {

    @Transactional(readOnly = true)
    override fun findAll(): List<CafeRes> = cafeRepository.findAll().map{it.toResponse()}

    fun Cafe.toResponse(): CafeRes =
        CafeRes(
            id = this.id,
            name = this.name,
            img = this.img,
            url = this.url,
            banner = this.banner
        )
}