package com.example.demo.Service;

import com.example.demo.Contract.CoordinatesDTO;
import com.example.demo.Exception.CoordinatesForDeviceNotFoundExeception;
import com.example.demo.Exception.CoordinatesIncorectFormExeception;
import com.example.demo.Mapper.CoordinatesMapperImpl;
import com.example.demo.Model.Coordinates;
import com.example.demo.Repository.CoordinatesRepository;
import com.example.demo.Validator.StringValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoordinatesService {

    @Autowired
    private CoordinatesRepository coordinatesRepository;

    @Autowired
    private CoordinatesMapperImpl mapper;


    public void save(CoordinatesDTO coordinatesDTO) throws CoordinatesIncorectFormExeception {
        //validation

        String latitude = coordinatesDTO.getLatitude();
        String longitude = coordinatesDTO.getLongitude();

        if(StringValidator.coordinateIsNotValid(latitude) || StringValidator.coordinateIsNotValid(longitude)){
            throw new CoordinatesIncorectFormExeception(latitude,longitude);
        }


        Coordinates coordinates = mapper.coordinatesDTOtoEntity(coordinatesDTO);

        coordinatesRepository.save(coordinates);
    }

    public List<CoordinatesDTO> getAllCoordinates() {
        return coordinatesRepository.findAll().stream().map(
                coordinates -> mapper.coordinatesToDTO(coordinates)
        ).collect(Collectors.toList());
    }

    public List<CoordinatesDTO> findByID(Integer id) throws CoordinatesForDeviceNotFoundExeception{

        List<Coordinates> coordinatesList = coordinatesRepository.findAllByDeviceID(id);

        if(coordinatesList.isEmpty()){
            throw new CoordinatesForDeviceNotFoundExeception(id);
        }


        return coordinatesList.stream().map(
                coordinates -> mapper.coordinatesToDTO(coordinates)).collect(Collectors.toList());
    }
}
