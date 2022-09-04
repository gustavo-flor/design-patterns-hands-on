package com.github.gustavoflor.behavioralpatterns.observer;

public class Application {
    public static void main(String[] args) {
        final var gustavo = new User("Gustavo");
        final var diego = new User("Diego");
        final var youtubeChannel = new YoutubeChannel()
                .addNewVideoEventHandler(gustavo)
                .addNewVideoEventHandler(diego)
                .addNewVideoEventHandler(event -> System.out.println("I'm a lambda event handler!!"));

        youtubeChannel.publishVideo("Clean Code");
        youtubeChannel.publishVideo("Java 17 Features");

        final var anotherChannel = new YoutubeChannel();

        anotherChannel.publishVideo("My first video!!!");

        anotherChannel.addNewVideoEventHandler(gustavo);

        anotherChannel.publishVideo("Thanks for the sub...");
    }
}
