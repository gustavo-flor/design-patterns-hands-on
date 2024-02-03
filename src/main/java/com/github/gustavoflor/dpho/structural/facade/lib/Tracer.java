package com.github.gustavoflor.dpho.structural.facade.lib;

import java.io.Closeable;
import java.io.IOException;

import static java.util.Objects.nonNull;

public record Tracer(String name, Tracer oldTracer) implements Closeable {

    @Override
    public void close() throws IOException {
        // do something
        if (nonNull(oldTracer)) {
            oldTracer.close();
        }
    }

}
