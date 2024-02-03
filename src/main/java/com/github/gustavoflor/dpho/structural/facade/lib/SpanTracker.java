package com.github.gustavoflor.dpho.structural.facade.lib;

import java.io.Closeable;
import java.io.IOException;

public class SpanTracker implements Closeable {

    private Tracer tracer;

    public Tracer next(final String name) {
        tracer = new Tracer(name, tracer);
        return tracer;
    }

    public void setEvent(final String event) {
        // do something
    }

    @Override
    public void close() throws IOException {
        tracer.close();
    }
}
