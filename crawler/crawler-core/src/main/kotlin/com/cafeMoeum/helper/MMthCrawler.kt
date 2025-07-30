package com.cafeMoeum.helper

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class MMthCrawler(
    @Value("\${crawler.server.url}")
    private val crawlerServerUrl: String
) {

    init {
        println(crawlerServerUrl)
    }
}