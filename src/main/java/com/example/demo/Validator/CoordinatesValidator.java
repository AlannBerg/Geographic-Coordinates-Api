package com.example.demo.Validator;


import com.example.demo.Contract.CoordinatesDTO;
import com.example.demo.Exception.CoordinatesIncorectFormExeception;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class CoordinatesValidator implements ConstraintValidator<Coordinates, CoordinatesDTO> {


    @Override
    public void initialize(Coordinates constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(CoordinatesDTO coordinatesDTO, ConstraintValidatorContext constraintValidatorContext) {

        String latitude = coordinatesDTO.getLatitude();
        String longitude = coordinatesDTO.getLongitude();

        if(latitude.matches("[0-9]+") && latitude.length() == 7 &&
                longitude.matches("[0-9]+") && longitude.length() == 7){
            return true;
        }else {
            throw new CoordinatesIncorectFormExeception(latitude,longitude);
        }

    }

}
