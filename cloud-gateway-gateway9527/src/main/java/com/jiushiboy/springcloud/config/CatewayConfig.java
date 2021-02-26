package com.jiushiboy.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author sh
 * @Date 2021/2/25 15:39
 */

@Configuration
public class CatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_rote_jiushiboy", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }

}
