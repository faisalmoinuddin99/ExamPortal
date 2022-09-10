package com.exam.exception;

public class UserFoundException extends Exception{

    public UserFoundException(){
        super("User with this Username is already there in DB !! try with another unique username");
    }

    public UserFoundException(String msg){
        super(msg);
    }

    public UserFoundException(int value, String message) {

    }
}
