package com.example.demo.Mapper;

import com.example.demo.Contract.CoordinatesDTO;
import com.example.demo.Model.CoordinatesEntity;
import org.mapstruct.Mapper;

@Mapper
public interface CoordinatesMapper {

    CoordinatesDTO coordinatesToDTO(CoordinatesEntity coordinatesEntity);

    CoordinatesEntity coordinatesDTOtoEntity(CoordinatesDTO dto);


}
