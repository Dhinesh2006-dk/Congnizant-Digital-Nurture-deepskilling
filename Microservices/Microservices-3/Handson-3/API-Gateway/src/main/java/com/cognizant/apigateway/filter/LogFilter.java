package com.cognizant.apigateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LogFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
                             GatewayFilterChain chain) {
        System.out.println("--------------------------------");
        System.out.println("Incoming Request");
        System.out.println(exchange.getRequest().getMethod());
        System.out.println(exchange.getRequest().getURI());
        System.out.println("--------------------------------");
        return chain.filter(exchange);
    }

}
