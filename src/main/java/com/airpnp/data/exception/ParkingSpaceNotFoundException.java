package com.airpnp.data.exception;

public class ParkingSpaceNotFoundException extends Exception {

    public ParkingSpaceNotFoundException(String message) {
        super(message);
    }

    public ParkingSpaceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
