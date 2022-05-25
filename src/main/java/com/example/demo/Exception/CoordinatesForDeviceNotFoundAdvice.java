package com.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CoordinatesForDeviceNotFoundAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    @ExceptionHandler({CoordinatesForDeviceNotFoundExeception.class})
    public String canNotFoundSuchDeviceID(CoordinatesForDeviceNotFoundExeception exc){
        return exc.getMessage();
    }
}
