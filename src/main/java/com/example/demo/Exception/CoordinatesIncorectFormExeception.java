package com.example.demo.Exception;

public class CoordinatesIncorectFormExeception extends RuntimeException{
    public CoordinatesIncorectFormExeception(String latitute, String longitute) {
        super("Coordinates : " + latitute + " , " + longitute + " are not correct. Coordinates must have 7 digits");
    }
}
