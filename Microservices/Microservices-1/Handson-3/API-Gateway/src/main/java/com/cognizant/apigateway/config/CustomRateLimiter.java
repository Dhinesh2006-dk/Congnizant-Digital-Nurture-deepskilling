package com.cognizant.apigateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RateLimiter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component("2")
public class CustomRateLimiter implements KeyResolver, RateLimiter<Object> {

    private final Map<String, TokenBucket> buckets = new ConcurrentHashMap<>();

    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        return Mono.just(exchange.getRequest().getRemoteAddress() != null 
            ? exchange.getRequest().getRemoteAddress().getAddress().getHostAddress() 
            : "anonymous");
    }

    @Override
    public Mono<Response> isAllowed(String routeId, String id) {
        // Capacity of 2, refill rate of 2 tokens per 2 seconds (which is 1 token per second)
        TokenBucket bucket = buckets.computeIfAbsent(id, k -> new TokenBucket(2, 1.0));
        boolean allowed = bucket.tryConsume();
        
        Response response = new Response(allowed, Map.of(
            "X-RateLimit-Remaining", String.valueOf(bucket.getTokens()),
            "X-RateLimit-Burst-Capacity", "2",
            "X-RateLimit-Replenish-Rate", "1"
        ));
        return Mono.just(response);
    }

    @Override
    public Map<String, Object> getConfig() {
        return Map.of();
    }

    @Override
    public Class<Object> getConfigClass() {
        return Object.class;
    }

    @Override
    public Object newConfig() {
        return new Object();
    }

    private static class TokenBucket {
        private final long capacity;
        private final double refillRate; // tokens per second
        private double tokens;
        private long lastRefillTimestamp;

        public TokenBucket(long capacity, double refillRate) {
            this.capacity = capacity;
            this.refillRate = refillRate;
            this.tokens = capacity;
            this.lastRefillTimestamp = System.currentTimeMillis();
        }

        public synchronized boolean tryConsume() {
            refill();
            if (tokens >= 1.0) {
                tokens -= 1.0;
                return true;
            }
            return false;
        }

        public synchronized long getTokens() {
            refill();
            return (long) tokens;
        }

        private void refill() {
            long now = System.currentTimeMillis();
            double elapsedTime = (now - lastRefillTimestamp) / 1000.0;
            tokens = Math.min(capacity, tokens + elapsedTime * refillRate);
            lastRefillTimestamp = now;
        }
    }
}
