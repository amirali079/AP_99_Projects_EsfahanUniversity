package com.example.mohammad_es_faz4_gui.BackEnd.Exceptions;

public class UnauthorizedNumberOfPassengersException extends RuntimeException {
    public UnauthorizedNumberOfPassengersException(String message){
        super(message);
    }
    public UnauthorizedNumberOfPassengersException(){
        super("The number of passengers is not allowed");
    }
}
