package com.example.ztuspringboot.Controller;

import com.example.ztuspringboot.DTO.CarRequest;
import com.example.ztuspringboot.DTO.CarResponse;
import com.example.ztuspringboot.Entity.Car;
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
        List<CarResponse> carResponses = carService.getAllCars();

        return ResponseEntity.ok(carResponses);
    }

    @GetMapping("/car/get/{id}")
    public ResponseEntity<?> getCar(@PathVariable("id") Integer id){

        return new ResponseEntity<>(carService.getCarById(id), HttpStatus.OK);
    }

    @DeleteMapping("car/delete/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable("id") Integer id){
        carService.deleteCar(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("car/post")
    public ResponseEntity <?> addCar(@RequestBody CarRequest carRequest){
        carService.saveCar(carRequest);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("car/put/{id}")
    public ResponseEntity<?> updateCar(@ PathVariable int id, @RequestBody CarRequest carRequest){
        carRequest.setId(33);

        return  ResponseEntity.noContent().build();
    }
}
