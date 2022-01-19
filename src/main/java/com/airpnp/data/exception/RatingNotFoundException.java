package com.airpnp.data.exception;

public class RatingNotFoundException extends Exception {

    public RatingNotFoundException(String message) {
        super(message);
    }

    public RatingNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
