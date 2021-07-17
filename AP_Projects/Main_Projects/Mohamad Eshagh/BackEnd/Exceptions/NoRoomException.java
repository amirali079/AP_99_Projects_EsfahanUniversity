package com.example.mohammad_es_faz4_gui.BackEnd.Exceptions;

public class NoRoomException extends RuntimeException {
    public NoRoomException(String message) {
        super(message);
    }

    public NoRoomException() {
        super("There is no room for adding this element");
    }
}
