package com.github.gustavoflor.behavioralpatterns.observer;

public class User implements NewVideoEventHandler {
    private final String name;

    public User(final String name) {
        this.name = name;
    }

    @Override
    public void handleNewVideo(NewVideoEvent event) {
        System.out.printf("Hey %s a new video was published with title = %s%n", name, event.videoTitle());
    }
}
