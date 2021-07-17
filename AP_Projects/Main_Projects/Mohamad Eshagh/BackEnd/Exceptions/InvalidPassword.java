package com.example.mohammad_es_faz4_gui.BackEnd.Exceptions;

public class InvalidPassword extends RuntimeException{
    public InvalidPassword(String message) {
        super(message);
    }
    public InvalidPassword() {
        super("You have entered wrong password.");
    }
}
