package com.cafeMoeum.helper

import com.cafeMoeum.dto.CategoryAndMenus
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriBuilder

@Component
class Crawler(
    @Value("\${crawler.server.url}")
    private val crawlerServerUrl: String
) {

    private val webClient: WebClient = WebClient.builder()
        .baseUrl(crawlerServerUrl)
        .build()

    fun getCategoryAndMenu(cafeType: String): CategoryAndMenus? {

        println(cafeType)

        return webClient.get()
            .uri { uriBuilder: UriBuilder ->
                uriBuilder
                    .path("/cafe")
                    .queryParam("cafe_type", cafeType)
                    .build()
            }
            .retrieve()
            .bodyToMono(CategoryAndMenus::class.java)
            .block()
    }

}