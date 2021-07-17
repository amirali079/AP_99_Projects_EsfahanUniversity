package com.example.mohammad_es_faz4_gui.BackEnd.Exceptions;

public class EmptyInputException extends InvalidInputException {
    public EmptyInputException(String message) {
        super(message);
    }
    public EmptyInputException() {
        super("The input is empty");
    }
}
