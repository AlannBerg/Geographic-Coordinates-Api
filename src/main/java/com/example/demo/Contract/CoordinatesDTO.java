package com.example.demo.Contract;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


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


