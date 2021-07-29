package com.shoryukane.section11.assignment;

import java.util.function.Consumer;

public class SlackMember {

    private String name;
    private Consumer<String> messageConsumer;

    public SlackMember(String name) {
        this.name = name;
    }

    void recieves(String message) {
        System.out.println(message);
    }

    public void says(String message) {
        this.messageConsumer.accept(message);
    }

    String getName() {
        return name;
    }

    void setMessageConsumer(Consumer<String> messageConsumer) {
        this.messageConsumer = messageConsumer;
    }

}
