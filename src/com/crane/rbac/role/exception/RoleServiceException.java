package com.crane.rbac.role.exception;

public class RoleServiceException extends RuntimeException {
    
    public RoleServiceException(){
    }
    
    public RoleServiceException(String message){
        super(message);
    }
    
    public RoleServiceException(Throwable cause){
        super(cause);
    }

}
