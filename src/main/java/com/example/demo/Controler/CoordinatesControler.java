package com.example.demo.Controler;

import com.example.demo.Contract.CoordinatesDTO;
import com.example.demo.Exception.CoordinatesForDeviceNotFoundExeception;
import com.example.demo.Exception.CoordinatesIncorectFormExeception;
import com.example.demo.Service.CoordinatesService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("/coordinates")
@RestController
public class CoordinatesControler {

    @Autowired
    private CoordinatesService coordinatesService;

    @GetMapping("/getAll")
    @ApiOperation(value = "Returns all coordinates and device ID from database")
    public ResponseEntity<List<CoordinatesDTO>> getAllCoordinates(){
        return new ResponseEntity<>(
                coordinatesService.getAllCoordinates(),
                HttpStatus.OK);
    }

    @PostMapping ("/getAllForThisDevice")
    @ApiOperation(value = "Returns all coordinates sent from specific device")
    public ResponseEntity<List<CoordinatesDTO>> getAllForThisDevice(@RequestParam int id) throws CoordinatesForDeviceNotFoundExeception {
        return new ResponseEntity<>(
                coordinatesService.findByDeviceID(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/add")
    @ApiOperation(value = "Saves new coordinates in database")
    public ResponseEntity<HttpStatus> addNewCoordinates(@ApiParam(value = "coordinatesDTO Json , latitude and longitude have 7 digits.")
            @Valid @RequestBody CoordinatesDTO coordinatesDTO) throws CoordinatesIncorectFormExeception {

        coordinatesService.save(coordinatesDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
