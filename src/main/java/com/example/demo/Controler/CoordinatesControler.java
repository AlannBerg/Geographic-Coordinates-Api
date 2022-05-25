package com.example.demo.Controler;

import com.example.demo.Contract.CoordinatesDTO;
import com.example.demo.Exception.CoordinatesForDeviceNotFoundExeception;
import com.example.demo.Exception.CoordinatesIncorectFormExeception;
import com.example.demo.Service.CoordinatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DecimalFormat;
import java.util.List;

@RequestMapping("/coordinates")
@RestController
public class CoordinatesControler {

    @Autowired
    private CoordinatesService coordinatesService;

    private DecimalFormat df = new DecimalFormat("0000000");

    @GetMapping("/getAll")
    public ResponseEntity<List<CoordinatesDTO>> getAllCoordinates(){
        return new ResponseEntity<>(
                coordinatesService.getAllCoordinates(),
                HttpStatus.OK);
    }

    @PostMapping ("/getAllForThisDevice")
    public ResponseEntity<List<CoordinatesDTO>> getAllForThisDevice( @RequestParam Integer id) throws CoordinatesForDeviceNotFoundExeception {
        return new ResponseEntity<>(
                coordinatesService.findByID(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addNewCoordinates(@Valid @RequestBody CoordinatesDTO coordinatesDTO) throws CoordinatesIncorectFormExeception {

        coordinatesService.save(coordinatesDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
