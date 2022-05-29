package com.example.demo;


import com.example.demo.Contract.CoordinatesDTO;
import com.example.demo.Exception.CoordinatesForDeviceNotFoundExeception;
import com.example.demo.Exception.CoordinatesIncorectFormExeception;
import com.example.demo.Mapper.CoordinatesMapper;
import com.example.demo.Mapper.CoordinatesMapperImpl;
import com.example.demo.Model.CoordinatesEntity;
import com.example.demo.Repository.CoordinatesRepository;
import com.example.demo.Service.CoordinatesService;
import com.example.demo.Validator.Coordinates;
import com.example.demo.Validator.CoordinatesValidator;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import javax.validation.Valid;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CoordinatesServiceTest {

    @Mock
    private CoordinatesRepository coordinatesRepository;




    private  final CoordinatesDTO coordinatesDTO = new CoordinatesDTO(
            1,
            "1234567",
            "1234567"
    );

    private  final CoordinatesEntity coordinatesEntity = new CoordinatesEntity(
            1,
            1,
            "1234567",
            "1234567"
    );

    private CoordinatesService coordinatesService;

    @BeforeEach
    void setUp() {
        coordinatesService = new CoordinatesService(coordinatesRepository);

    }


    @Test
    void savingNewCoordinatesShouldBeSuccesfullTest(){

        ArgumentCaptor<CoordinatesEntity> argCaptor= ArgumentCaptor.forClass(CoordinatesEntity.class);

        coordinatesService.save(coordinatesDTO);

        verify(coordinatesRepository).save(argCaptor.capture());

        Assert.assertEquals(coordinatesDTO.getDeviceId(),coordinatesEntity.getDeviceId());
        Assert.assertEquals(coordinatesDTO.getLatitude(),coordinatesEntity.getLatitude());
        Assert.assertEquals(coordinatesDTO.getLongitude(),coordinatesEntity.getLongitude());

    }


    @Test
    void getingListOfAllCustomersShouldReturnListOfCustomersTEST(){

        when(coordinatesRepository.findAll()).thenReturn(List.of(coordinatesEntity, coordinatesEntity));


        List<CoordinatesDTO> returnedList = coordinatesService.getAllCoordinates();

        Assert.assertEquals(2,returnedList.size());
        Assert.assertEquals(coordinatesDTO.getClass(), returnedList.get(0).getClass());


    }


    @Test
    void getingAllCoordinatesForDeviceIDShouldReturnListTEST(){
        int providedID = 1;

        when(coordinatesRepository.findAllByDeviceID(providedID)).thenReturn(List.of(coordinatesEntity, coordinatesEntity));


        List<CoordinatesDTO> returnedList = coordinatesService.findByDeviceID(providedID);

        Assert.assertEquals(2,returnedList.size());
        Assert.assertEquals(coordinatesDTO.getClass(), returnedList.get(0).getClass());


    }

    @Test
    void getingAllCoordinatesForDeviceIDWhenThereIsNoSuchDeviceShouldThrowExceptionTEST(){
        int providedID = 1;

        when(coordinatesRepository.findAllByDeviceID(providedID)).thenReturn(Collections.emptyList());


        Exception exception = Assert.assertThrows(CoordinatesForDeviceNotFoundExeception.class,
                () ->  coordinatesService.findByDeviceID(providedID));

        Assert.assertEquals("Coordinates for device id = 1 does not exist",exception.getMessage());

    }


}
