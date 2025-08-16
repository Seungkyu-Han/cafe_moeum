package com.cafeMoeum

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class CafeMoeumApplication

fun main(args: Array<String>) {
    runApplication<CafeMoeumApplication>(*args)
}