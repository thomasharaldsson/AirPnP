package com.airpnp.data.exception;

public class ParkingSpaceAlreadyRented extends Exception {

    public ParkingSpaceAlreadyRented(String message) {
        super(message);
    }

    public ParkingSpaceAlreadyRented(String message, Throwable cause) {
        super(message, cause);
    }
}