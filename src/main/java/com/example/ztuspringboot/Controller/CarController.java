package com.example.ztuspringboot.Controller;

import com.example.ztuspringboot.DTO.CarRequest;
import com.example.ztuspringboot.DTO.CarResponse;
import com.example.ztuspringboot.Service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    private final CarService carService;

    CarController(final CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars/all")
    public ResponseEntity<List<CarResponse>> getAllCars(){
        List<CarResponse> cars = carService.getAllCars();

        return new ResponseEntity<>(cars, HttpStatus.OK);

    }

    @GetMapping("/car/get/{id}")
    public ResponseEntity<?> getCar(@PathVariable("id") Integer id){

        return new ResponseEntity<>(carService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("car/delete/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable("id") Integer id){
        carService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("car/post")
    public ResponseEntity <?> addCar(@RequestBody CarRequest carRequest){
        carService.save(carRequest);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("car/put/{id}")
    public ResponseEntity<?> update(@ PathVariable int id, @RequestBody CarRequest carRequest){
        carRequest.setId(33);

        return  ResponseEntity.noContent().build();
    }
}
