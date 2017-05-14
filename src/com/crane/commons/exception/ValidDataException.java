package com.crane.commons.exception;

public class ValidDataException extends RuntimeException {
    
    public ValidDataException(){
    }
    
    public ValidDataException(String message){
        super(message);
    }
    
    public ValidDataException(Throwable cause){
        super(cause);
    }

}
