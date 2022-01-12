package com.airpnp.data.exception;

public class VehicleTypeNotFoundException extends Exception {
    public VehicleTypeNotFoundException(String message) {
        super(message);
    }

    public VehicleTypeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
