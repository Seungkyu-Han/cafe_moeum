package com.cafeMoeum.helper

import com.cafeMoeum.dto.CategoryAndMenus
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class Crawler(
    @Value("\${crawler.server.url}")
    private val crawlerServerUrl: String
) {

    fun getCategoryAndMenu(cafeType: String): CategoryAndMenus? {
        return WebClient.create()
            .get()
            .uri("${crawlerServerUrl}/cafe?cafe_type=${cafeType}")
            .retrieve()
            .bodyToMono(CategoryAndMenus::class.java)
            .block()
    }

}