package com.airpnp.data.exception;

public class RentalTicketNotFoundException extends Exception{
    public RentalTicketNotFoundException(String message) {
        super(message);
    }

    public RentalTicketNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
