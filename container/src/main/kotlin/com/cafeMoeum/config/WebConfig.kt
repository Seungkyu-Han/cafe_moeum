package com.cafeMoeum.config

import com.cafeMoeum.service.HitRecordService
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig(
    @Value("\${cors.mapping-url}")
    private val mappingUrl: String,
    private val hitRecordService: HitRecordService
): WebMvcConfigurer {

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(hitRecordService).addPathPatterns("/**")
        super.addInterceptors(registry)
    }

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping(mappingUrl)
            .allowedOriginPatterns("**")
            .allowedMethods("*")
            .allowedHeaders("*")
            .allowCredentials(true)
    }
}