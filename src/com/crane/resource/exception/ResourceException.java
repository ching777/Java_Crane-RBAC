package com.crane.resource.exception;

public class ResourceException extends RuntimeException{

    public ResourceException(){
    }

    public ResourceException(String message){
        super(message);
    }

    public ResourceException(Throwable cause){
        super(cause);
    }

}
