package com.example.demo.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class CoordinatesForDeviceNotFoundAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    @ExceptionHandler({CoordinatesForDeviceNotFoundExeception.class})
    public String canNotFoundSuchDeviceID(CoordinatesForDeviceNotFoundExeception exc){
        log.warn("Exception, can not found such device, exception message: {} ",exc.getMessage());
        return exc.getMessage();
    }
}
