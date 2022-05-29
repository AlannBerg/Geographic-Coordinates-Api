package com.example.demo.Service;

import com.example.demo.Contract.CoordinatesDTO;
import com.example.demo.Exception.CoordinatesForDeviceNotFoundExeception;
import com.example.demo.Exception.CoordinatesIncorectFormExeception;
import com.example.demo.Mapper.CoordinatesMapperImpl;
import com.example.demo.Model.CoordinatesEntity;
import com.example.demo.Repository.CoordinatesRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Validated
@AllArgsConstructor
public class CoordinatesService {

    @Autowired
    private CoordinatesRepository coordinatesRepository;


    public void save(@Valid CoordinatesDTO coordinatesDTO) throws CoordinatesIncorectFormExeception {


        CoordinatesEntity coordinatesEntity = CoordinatesMapperImpl.INSTANCE.coordinatesDTOtoEntity(coordinatesDTO);


        log.info("Saving new coordinates: {} , {}, {} ", coordinatesEntity.getDeviceId(), coordinatesEntity.getLatitude(), coordinatesEntity.getLongitude());

        coordinatesRepository.save(coordinatesEntity);
    }

    public List<CoordinatesDTO> getAllCoordinates() {
        log.info("Getting all coordinates from database");

        return coordinatesRepository.findAll().stream().map(
                CoordinatesMapperImpl.INSTANCE::coordinatesToDTO
        ).collect(Collectors.toList());
    }

    public List<CoordinatesDTO> findByDeviceID(Integer id) throws CoordinatesForDeviceNotFoundExeception{

        List<CoordinatesEntity> coordinatesEntityList = coordinatesRepository.findAllByDeviceID(id);

        if(coordinatesEntityList.isEmpty()){

            throw new CoordinatesForDeviceNotFoundExeception(id);
        }

        log.info("Returning list of coordinates for device id = {}", id);
        return coordinatesEntityList.stream().map(
                CoordinatesMapperImpl.INSTANCE::coordinatesToDTO).collect(Collectors.toList());
    }
}
