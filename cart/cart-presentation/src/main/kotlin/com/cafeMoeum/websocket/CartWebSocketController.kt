package com.cafeMoeum.websocket

import com.cafeMoeum.dto.MenuBoardReqDto
import com.cafeMoeum.service.CartService
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.RestController

@RestController
class CartWebSocketController(
    private val simpMessagingTemplate: SimpMessagingTemplate,
    private val cartService: CartService
) {

    @MessageMapping("/{cartId}")
    fun updateMenu(
        menuBoardReqDto: MenuBoardReqDto,
        @DestinationVariable("cartId") cartId: String,
        ){

        val menuBoardResDto = cartService.updateCart(menuBoardReqDto, cartId)

        simpMessagingTemplate.convertAndSend("/sub/$cartId", menuBoardResDto)
    }
}