package com.example.mohammad_es_faz4_gui.BackEnd.Exceptions;

public class InvalidUsername extends RuntimeException{
    public InvalidUsername(String message) {
        super(message);
    }
    public InvalidUsername() {
        super("You have entered wrong username.");
    }
}
