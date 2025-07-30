package com.cafeMoeum.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.servers.Server
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig(
    @Value("\${server.url}")
    private val serverUrl: String
) {

    @Bean
    fun openApi(): OpenAPI =
        OpenAPI()
            .info(
                Info()
                .title("Cafe-Moeum API")
                .description("Cafe-Moeum API 문서입니다.")
            )
            .addServersItem(Server().url(serverUrl).description("개발 서버"))

}