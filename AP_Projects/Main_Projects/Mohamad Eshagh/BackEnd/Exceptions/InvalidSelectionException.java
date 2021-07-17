package com.example.mohammad_es_faz4_gui.BackEnd.Exceptions;

public class InvalidSelectionException extends InvalidInputException {
    public InvalidSelectionException(String message) {
        super(message);
    }
    public InvalidSelectionException() {
        super("You have entered wrong number.");
    }
}
