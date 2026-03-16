package com.example.wine_tracker.exception;

public class WineNotFoundException extends RuntimeException {

    public WineNotFoundException(Long id) {
        super("Wine with id " + id + " not found");
    }
}
