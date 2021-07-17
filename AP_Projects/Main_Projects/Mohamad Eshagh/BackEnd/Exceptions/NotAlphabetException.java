package com.example.mohammad_es_faz4_gui.BackEnd.Exceptions;

public class NotAlphabetException extends InvalidInputException{
    public NotAlphabetException() {
        super("Not alphabet character found");
    }
    public NotAlphabetException(String message) {
        super(message);
    }
}
