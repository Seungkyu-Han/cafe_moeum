package com.cafeMoeum.controller

import com.cafeMoeum.dto.CafeReq
import com.cafeMoeum.dto.CafeRes
import com.cafeMoeum.service.CafeService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/cafes")
class CafeController(
    private val cafeService: CafeService
){

    @GetMapping
    fun findAll(): List<CafeRes> = cafeService.findAll()

    @DeleteMapping
    fun delete(@RequestParam id: UUID) = cafeService.remove(id)

    @PostMapping
    fun create(@RequestBody cafeReq: CafeReq) = cafeService.create(name = cafeReq.name, img = cafeReq.img)

}