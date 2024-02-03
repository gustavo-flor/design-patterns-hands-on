package com.github.gustavoflor.dpho.structural.proxy;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ExternalServiceProxy {

    private static final Integer RATE_LIMIT = 2;

    private final ExternalService externalService;

    private int connections;
    private LocalDateTime lastConnection;

    public ExternalServiceProxy(ExternalService externalService) {
        this.externalService = externalService;
        this.connections = 0;
        this.lastConnection = LocalDateTime.now();
    }

    public void call() {
        final var now = LocalDateTime.now();
        final var minutesPassed = ChronoUnit.MINUTES.between(lastConnection, now);
        if (minutesPassed > 0) {
            connections = 0;
        }
        connections++;
        if (connections > RATE_LIMIT) {
            throw new RateLimitException();
        }
        externalService.call();
        lastConnection = now;
    }

}
