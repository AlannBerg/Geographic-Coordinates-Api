package com.example.demo.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class CoordinatesIncorectFormAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(CoordinatesIncorectFormExeception.class)
    public String wrongCoordinatesHandler(CoordinatesIncorectFormExeception exc){
        log.warn("Exception, wrong coordinates. Exception message: {}" ,exc.getMessage());
        return exc.getMessage();
    }
}