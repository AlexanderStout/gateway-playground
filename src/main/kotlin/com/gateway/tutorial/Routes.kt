package com.gateway.tutorial

import org.springframework.cloud.gateway.filter.factory.SpringCloudCircuitBreakerFilterFactory
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec
import org.springframework.cloud.gateway.route.builder.PredicateSpec
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class Routes {

  @Bean
  fun myRoutes(builder: RouteLocatorBuilder): RouteLocator {
    return builder.routes()
      .route { p: PredicateSpec ->
        p
          .path("/get")
          .filters { f: GatewayFilterSpec ->
            f.addRequestHeader(
              "Hello",
              "World"
            )
          }
          .uri("http://httpbin.org:80")
      }
      .route { p: PredicateSpec ->
        p
          .host("*.circuitbreaker.com")
          .filters { f: GatewayFilterSpec ->
            f.circuitBreaker { config: SpringCloudCircuitBreakerFilterFactory.Config ->
              config.setName(
                "mycmd"
              )
            }
          }
          .uri("http://httpbin.org:80")
      }.build()
  }
}