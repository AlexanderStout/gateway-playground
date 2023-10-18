package com.gateway.tutorial

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean


@SpringBootApplication
class GatewayApplication

fun main(args: Array<String>) {
  runApplication<GatewayApplication>(*args)
}



