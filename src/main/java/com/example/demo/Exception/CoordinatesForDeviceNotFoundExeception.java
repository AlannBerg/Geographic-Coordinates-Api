package com.example.demo.Exception;

import java.util.UUID;

public class CoordinatesForDeviceNotFoundExeception extends RuntimeException{
    public CoordinatesForDeviceNotFoundExeception(Integer id) {
        super("Coordinates for device id = "+ id +" does not exist");
    }
}
