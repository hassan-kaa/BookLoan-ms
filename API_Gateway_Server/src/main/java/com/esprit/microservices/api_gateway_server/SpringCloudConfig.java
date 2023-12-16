package com.esprit.microservices.api_gateway_server;

import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
@Configuration
public class SpringCloudConfig {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder routeLocatorBuilder){
         routeLocatorBuilder.routes()
                //book-service
                .route(r -> r.path("/books/**").uri("http://localhost:8082/"));
        //borrowing-service
                routeLocatorBuilder.routes().route(r -> r.path("/books/**").uri("http://localhost:8082/"));
                return routeLocatorBuilder.routes().build();
    }
}
