package com.cafeMoeum.controller

import com.cafeMoeum.dto.CafeRes
import com.cafeMoeum.service.CafeService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cafes")
@Tag(name = "카페 API", description = "저장된 카페들의 목록을 조회합니다.")
class CafeController(
    private val cafeService: CafeService
){

    @GetMapping
    @Operation(summary = "카페들의 전체 목록을 조회합니다.")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "카페 목록 성공")
    )
    fun findAll(): ResponseEntity<List<CafeRes>>{
        return ResponseEntity.ok(cafeService.findAll())
    }
}