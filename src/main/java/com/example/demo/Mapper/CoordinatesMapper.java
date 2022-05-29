package com.example.demo.Mapper;

import com.example.demo.Contract.CoordinatesDTO;
import com.example.demo.Model.CoordinatesEntity;
import com.google.common.annotations.VisibleForTesting;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
@VisibleForTesting
public interface CoordinatesMapper {

    CoordinatesMapper INSTANCE = Mappers.getMapper(CoordinatesMapper.class);

    CoordinatesDTO coordinatesToDTO(CoordinatesEntity coordinatesEntity);

    CoordinatesEntity coordinatesDTOtoEntity(CoordinatesDTO dto);


}
