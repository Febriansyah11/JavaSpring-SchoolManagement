package com.school.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ExceptionSize{

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class NameSize extends RuntimeException{

        public NameSize(){
            super("Name should have atleast 3 characters");
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class PasswordSize extends RuntimeException{

        public PasswordSize(){
            super("Password should have atleast 8 characters");
        }
    }


}
