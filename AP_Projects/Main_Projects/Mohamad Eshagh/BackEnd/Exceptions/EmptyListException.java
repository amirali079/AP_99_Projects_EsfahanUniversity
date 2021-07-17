package com.example.mohammad_es_faz4_gui.BackEnd.Exceptions;

public class EmptyListException extends RuntimeException{
    public EmptyListException(String message) {
        super(message);
    }

    public EmptyListException() {
        super("There is no element");
    }
}
