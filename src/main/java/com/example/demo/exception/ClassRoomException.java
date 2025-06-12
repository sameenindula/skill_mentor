package com.example.demo.exception;

public class ClassRoomException extends Exception {

    public ClassRoomException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ClassRoomException(String message) {
        super(message);
    }

    public ClassRoomException() {
        super();
    }
}
