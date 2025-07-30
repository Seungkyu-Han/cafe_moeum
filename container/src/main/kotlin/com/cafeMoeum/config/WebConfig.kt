package com.cafeMoeum.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig(
    @Value("\${cors.mapping-url}")
    private val mappingUrl: String
): WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping(mappingUrl)
            .allowedOriginPatterns("**")
            .allowedMethods("*")
            .allowedHeaders("*")
            .allowCredentials(true)
    }
}