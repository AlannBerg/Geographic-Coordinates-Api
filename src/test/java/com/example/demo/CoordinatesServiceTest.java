package com.example.demo;


import com.example.demo.Contract.CoordinatesDTO;
import com.example.demo.Mapper.CoordinatesMapper;
import com.example.demo.Mapper.CoordinatesMapperImpl;
import com.example.demo.Model.CoordinatesEntity;
import com.example.demo.Repository.CoordinatesRepository;
import com.example.demo.Service.CoordinatesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {CoordinatesMapperImpl.class})
public class CoordinatesServiceTest {
//
//    @Mock
//    private CoordinatesRepository coordinatesRepository;
//
//    @Spy
//    private CoordinatesMapper coordinatesMapper = Mappers.getMapper(CoordinatesMapper.class);
//
//
//    private  final CoordinatesDTO coordinatesDTO = new CoordinatesDTO(
//            1,
//            "1234567",
//            "1234567"
//    );
//
//    private  final CoordinatesEntity coordinatesEntity = new CoordinatesEntity(
//            1,
//            1,
//            "123b567",
//            "123a567"
//    );
//
//    private CoordinatesService coordinatesService;
//
////    @BeforeEach
////    void setUp() {
////        coordinatesService = new CoordinatesService(coordinatesRepository,coordinatesMapper);
////
////    }
//
//
//    @Test
//    void savingNewCoordinatesShouldBeSuccesfullTest(){
//
////        coordinatesService.save(coordinatesDTO);
////
////       verify(CoordinatesMapperImpl.INSTANCE).coordinatesDTOtoEntity(coordinatesDTO);
////        verify(coordinatesRepository).save(coordinatesEntity);
////
////    }
}
