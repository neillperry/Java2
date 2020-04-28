package com.entertainment;

public class ChannelDisallowedException extends Exception {

    public ChannelDisallowedException() {
    }

    public ChannelDisallowedException(String message) {
        super(message);
    }
}
