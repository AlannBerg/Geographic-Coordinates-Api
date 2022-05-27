package com.example.demo.Contract;

import com.example.demo.Validator.Coordinates;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Coordinates
@Setter
@Getter
@AllArgsConstructor
public class CoordinatesDTO {

    @NotNull
    private Integer deviceId;

    @NotBlank
    private String latitude;

    @NotBlank
    private String longitude;


    }


