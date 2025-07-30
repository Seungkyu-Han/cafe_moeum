package com.cafeMoeum.controller

import com.cafeMoeum.dto.CafeRes
import com.cafeMoeum.service.CafeService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cafes")
class CafeController(
    private val cafeService: CafeService
){

    @GetMapping
    fun findAll(): List<CafeRes> = cafeService.findAll()
}