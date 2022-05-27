package com.example.demo.Mapper;

import com.example.demo.Contract.CoordinatesDTO;
import com.example.demo.Model.CoordinatesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CoordinatesMapper {


    CoordinatesDTO coordinatesToDTO(CoordinatesEntity coordinatesEntity);

    CoordinatesEntity coordinatesDTOtoEntity(CoordinatesDTO dto);


}
