package com.cafeMoeum.controller

import com.cafeMoeum.dto.HitCountRes
import com.cafeMoeum.service.HitReadService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hit")
@Tag(name = "조회수 API", description = "방문자의 수를 조회합니다.")
class HitController(
    private val hitReadService: HitReadService
) {

    @GetMapping
    @Operation(summary = "방문자 수를 가져옵니다.")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "방문자 수 조회 성공")
    )
    fun getHitCount(): ResponseEntity<HitCountRes>{
        return ResponseEntity.ok(hitReadService.getHitCount())
    }
}