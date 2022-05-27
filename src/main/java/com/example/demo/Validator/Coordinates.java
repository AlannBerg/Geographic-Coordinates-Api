package com.example.demo.Validator;

import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CoordinatesValidator.class)
@Target({ElementType.TYPE_USE, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Coordinates{

    String message() default "Invalid coordinates";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
