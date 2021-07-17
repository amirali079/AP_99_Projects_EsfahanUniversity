package com.example.mohammad_es_faz4_gui.BackEnd.Exceptions;

public class AirstripLengthMisMatchException extends RuntimeException {
    public AirstripLengthMisMatchException(String message){
        super(message);
    }
    public AirstripLengthMisMatchException(){
        super("The airstrip length of airports is shorter than this airplane required airstrip length");
    }
}
