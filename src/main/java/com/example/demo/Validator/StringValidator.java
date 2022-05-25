package com.example.demo.Validator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringValidator {

    public static boolean coordinateIsNotValid(String digitString){

        log.info("Validating coordinates : {}" , digitString);

        return digitString.matches("[0-9]+") == false || digitString.length() != 7;

        // coordinate is not valid when it has a letter inside or it's lenght is not 7
    }
}
