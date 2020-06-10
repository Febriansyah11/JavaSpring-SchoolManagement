package com.school.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ExceptionResponse {

    @ResponseStatus(HttpStatus.CONFLICT)
        public static class EmailOrPhoneNumberAlreadyUsed extends RuntimeException{

        public EmailOrPhoneNumberAlreadyUsed(){
            super("Email Or Phone Number already used!");
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class PhoneNumberAlreadyUsed extends RuntimeException{

        public PhoneNumberAlreadyUsed(){
            super("Phone Number already used!");
        }
    }


}
