package com.vizirgb.backend2k90.exceptions;

public class UserAlreadyExistsException extends Exception {

    public UserAlreadyExistsException(String msg) {
        super(msg);
    }

    public UserAlreadyExistsException(String msg, Throwable err) {
        super(msg, err);
    }
}
