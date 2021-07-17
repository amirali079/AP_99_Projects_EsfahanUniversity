package com.example.mohammad_es_faz4_gui.BackEnd.Exceptions;

public abstract class InvalidInputException extends RuntimeException{
    public InvalidInputException(String message) {
        super(message);
    }
}
