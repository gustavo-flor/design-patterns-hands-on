package com.github.gustavoflor.dpho.structural.facade;

import com.github.gustavoflor.dpho.structural.facade.lib.SpanTracker;
import com.github.gustavoflor.dpho.structural.facade.lib.TraceException;

import java.io.IOException;

public class TraceFacade {

    private final SpanTracker spanTracker;

    public TraceFacade(SpanTracker spanTracker) {
        this.spanTracker = spanTracker;
    }

    public void track(final Runnable runnable) {
        try (final var ignored = spanTracker.next("track")) {
            spanTracker.setEvent("start-track");
            runnable.run();
            spanTracker.setEvent("end-track");
        } catch (IOException e) {
            System.err.printf("Ops... something went wrong with message = %s%n", e.getMessage());
        }
    }

}
