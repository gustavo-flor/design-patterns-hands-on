package com.github.gustavoflor.behavioralpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements NewVideoEventHandler {
    private final List<NewVideoEventHandler> newVideoEventHandlers = new ArrayList<>();

    public void publishVideo(final String videoTitle) {
        System.out.printf("New video published with title = %s%n", videoTitle);
        final var event = new NewVideoEvent(videoTitle);
        newVideoEventHandlers.forEach(handler -> handler.handleNewVideo(event));
    }

    public YoutubeChannel addNewVideoEventHandler(final NewVideoEventHandler handler) {
        newVideoEventHandlers.add(handler);
        return this;
    }

    @Override
    public void handleNewVideo(final NewVideoEvent event) {
        final var message = "A Youtube channel can observe events, this video was published with title = %s%n";
        System.out.printf(message, event.videoTitle());
    }
}
