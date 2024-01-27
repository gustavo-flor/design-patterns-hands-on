package com.github.gustavoflor.dpho.creational.singleton;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.Objects.isNull;

public class Singleton {

    private static final ReentrantLock LOCK = new ReentrantLock();

    private static Singleton instance;

    private final LocalDateTime createdAt;

    private Singleton() {
        this.createdAt = LocalDateTime.now();
    }

    public static Singleton getInstance() {
        LOCK.lock();
        try {
            if (isNull(instance)) {
                instance = new Singleton();
            }
        } finally {
            LOCK.unlock();
        }
        return instance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
