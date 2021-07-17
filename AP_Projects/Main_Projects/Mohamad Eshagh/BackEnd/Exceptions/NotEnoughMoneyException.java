package com.example.mohammad_es_faz4_gui.BackEnd.Exceptions;

public class NotEnoughMoneyException     extends RuntimeException{
    public NotEnoughMoneyException(String message) {
        super(message);
    }
    public NotEnoughMoneyException() {
        super("The money of city is not enough");
    }
}
