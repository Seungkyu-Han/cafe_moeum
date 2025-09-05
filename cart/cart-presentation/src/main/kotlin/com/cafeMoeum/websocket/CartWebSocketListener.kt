package com.cafeMoeum.websocket

import com.cafeMoeum.service.CartService
import org.springframework.context.event.EventListener
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.messaging.simp.stomp.StompHeaderAccessor
import org.springframework.stereotype.Component
import org.springframework.web.socket.messaging.SessionSubscribeEvent

@Component
class CartWebSocketListener (
    private val simpMessagingTemplate: SimpMessagingTemplate,
    private val cartService: CartService
) {

    @EventListener
    fun handleCartWebSocketSubscribe(event: SessionSubscribeEvent){
        val accessor = StompHeaderAccessor.wrap(event.message)
        val destination = accessor.destination

        if (destination != null && destination.startsWith("/sub")){
            val cartId = destination.removePrefix("/sub/")
            simpMessagingTemplate.convertAndSend("/sub/$cartId", cartService.getCart(cartId))
        }
    }
}