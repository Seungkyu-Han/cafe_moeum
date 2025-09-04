package com.cafeMoeum.websocket

import com.cafeMoeum.dto.MenuBoardReqDto
import com.cafeMoeum.dto.MenuBoardResDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.Parameters
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/websocket/cart")
class CartWebSocketDocs {

    @PostMapping("/sub/{cartId}",)
    @Operation(summary = "장바구니 구독", description = "/sub/{cartId}가 구독 주소입니다.")
    @Parameters(
        Parameter(name = "cartId", description = "구독할 방의 번호"),
    )
    fun subscribe(@PathVariable cartId: String) {}

    @PostMapping("/pub/{roomId}")
    @Operation(summary = "게임방 이벤트 전송")
    @Parameters(
        Parameter(name = "roomId", description = "/pub/{cartId}가 이벤트 주소입니다.")
    )
    @ApiResponses(
        ApiResponse(responseCode = "200", content = [Content(schema = Schema(implementation = MenuBoardResDto::class))]),
    )
    fun publish(@PathVariable roomId: String, @RequestBody menuBoardReqDto: MenuBoardReqDto) {}
}