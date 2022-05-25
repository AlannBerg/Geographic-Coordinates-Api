package com.example.demo.Mapper;

import com.example.demo.Contract.CoordinatesDTO;
import com.example.demo.Model.Coordinates;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CoordinatesMapper {

    CoordinatesDTO coordinatesToDTO(Coordinates coordinates);

    Coordinates coordinatesDTOtoEntity(CoordinatesDTO dto);


}
