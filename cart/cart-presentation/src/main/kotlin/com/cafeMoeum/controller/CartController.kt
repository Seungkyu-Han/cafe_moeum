package com.cafeMoeum.controller

import com.cafeMoeum.dto.CartReq
import com.cafeMoeum.dto.CartRes
import com.cafeMoeum.dto.UpdateCartReq
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/carts")
@Tag(name = "장바구니 API", description = "장바구니를 열고 닫는 API입니다.")
class CartController{

    @PostMapping
    @Operation(summary = "장바구니를 생성합니다.")
    @ApiResponses(
        ApiResponse(responseCode = "201", description = "생성 성공")
    )
    fun createCart(@RequestBody cartReq: CartReq): ResponseEntity<CartRes> {
        return ResponseEntity.status(HttpStatus.CREATED).body(CartRes(cartId = UUID.randomUUID().toString()))
    }

    @PatchMapping
    @Operation(summary = "장바구니를 마감합니다.")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "생성 성공")
    )
    fun updateCart(@RequestBody updateCartReq: UpdateCartReq): ResponseEntity<CartRes> {
        return ResponseEntity.status(HttpStatus.CREATED).body(CartRes(cartId = UUID.randomUUID().toString()))
    }

}