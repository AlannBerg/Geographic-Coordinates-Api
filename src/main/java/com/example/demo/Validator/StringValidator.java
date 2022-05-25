package com.example.demo.Validator;

public class StringValidator {

    public static boolean coordinateIsNotValid(String digitString){

        return digitString.matches("[0-9]+") == false || digitString.length() != 7;

        // coordinate is not valid when it has a letter inside or it's lenght is not 7
    }
}
