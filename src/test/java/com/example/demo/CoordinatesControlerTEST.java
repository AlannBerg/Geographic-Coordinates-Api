package com.example.demo;


import com.example.demo.Contract.CoordinatesDTO;
import com.example.demo.Controler.CoordinatesControler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mockito.ArgumentCaptor;
import org.springframework.http.MediaType;
import com.example.demo.Mapper.CoordinatesMapperImpl;
import com.example.demo.Model.CoordinatesEntity;
import com.example.demo.Repository.CoordinatesRepository;
import com.example.demo.Service.CoordinatesService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CoordinatesControler.class)
public class CoordinatesControlerTEST {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CoordinatesService coordinatesService;



    private  final CoordinatesDTO coordinatesDTO = new CoordinatesDTO(
            1,
            "1234567",
            "1234567"
    );

    private  final CoordinatesEntity coordinatesEntity = new CoordinatesEntity(
            1,
            1,
            "123b567",
            "123a567"
    );

    @Test
    void getallshouldReturnListOfOneCoordinatesDTOTest() throws Exception {


        String uri = "/coordinates/getAll";

        when(coordinatesService.getAllCoordinates()).thenReturn(List.of(coordinatesDTO));


        RequestBuilder request = MockMvcRequestBuilders.get(uri);
        MvcResult result = mvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();

        Assert.assertEquals("[{\"deviceId\":1,\"latitude\":\"1234567\",\"longitude\":\"1234567\"}]",result.getResponse().getContentAsString());
    }

    @Test
    void getAllForThisDeviceByIdshouldReturnCoordinatesDTOTest() throws Exception {


        String uri = "/coordinates/getAllForThisDevice";
        int givenId = 1;

        when(coordinatesService.findByDeviceID(givenId)).thenReturn(List.of(coordinatesDTO));

        RequestBuilder request = MockMvcRequestBuilders.post(uri)
                .param("id", String.valueOf(givenId))
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();

        Assert.assertEquals("[{\"deviceId\":1,\"latitude\":\"1234567\",\"longitude\":\"1234567\"}]",result.getResponse().getContentAsString());
    }

    @Test
    void addNewCoordinatesShoudBeSuccesfullTest() throws Exception {


        String uri = "/coordinates/add";


        RequestBuilder request = MockMvcRequestBuilders.post(uri)
                .content(asJsonString(coordinatesDTO))
                .contentType(MediaType.APPLICATION_JSON)
                ;

        mvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();


        ArgumentCaptor<CoordinatesDTO> argumentCaptor = ArgumentCaptor.forClass(CoordinatesDTO.class);

        verify(coordinatesService).save(argumentCaptor.capture());
        Assert.assertEquals((long) 1, (long) argumentCaptor.getValue().getDeviceId());
        Assert.assertEquals("1234567",argumentCaptor.getValue().getLatitude());
        Assert.assertEquals("1234567",argumentCaptor.getValue().getLongitude());

    }

    @Test()
    void addIncorrectCoordinateswithLetterShouldHaveStatus400andReturnMessage() throws Exception {

        String uri = "/coordinates/add";


        RequestBuilder request = MockMvcRequestBuilders.post(uri)
                .content("   {\n" +
                        "        \"deviceId\": 10,\n" +
                        "        \"latitude\": \"1234b67\",\n" +
                        "        \"longitude\": \"1234567\"\n" +
                        "    }")
                .contentType(MediaType.APPLICATION_JSON)
                ;


         MockHttpServletResponse response = (mvc.perform(request)
                .andExpect(status().isBadRequest())
                .andReturn().getResponse());

        Assert.assertEquals("Coordinates : 1234b67 , 1234567 are not correct. Coordinates must have 7 digits",
                response.getContentAsString());

    }

    @Test()
    void addToShortCoordinatesShouldHaveStatus400andReturnMessage() throws Exception {

        String uri = "/coordinates/add";


        RequestBuilder request = MockMvcRequestBuilders.post(uri)
                .content("   {\n" +
                        "        \"deviceId\": 10,\n" +
                        "        \"latitude\": \"17\",\n" +
                        "        \"longitude\": \"17\"\n" +
                        "    }")
                .contentType(MediaType.APPLICATION_JSON)
                ;


        MockHttpServletResponse response = (mvc.perform(request)
                .andExpect(status().isBadRequest())
                .andReturn().getResponse());

        Assert.assertEquals("Coordinates : 17 , 17 are not correct. Coordinates must have 7 digits",
                response.getContentAsString());

    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
