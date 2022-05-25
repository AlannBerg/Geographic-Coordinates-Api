package com.example.demo.Exception;

public class CoordinatesForDeviceNotFoundExeception extends RuntimeException{
    public CoordinatesForDeviceNotFoundExeception(Integer id) {
        super("Coordinates for device id = "+ id +" does not exist");
    }
}
