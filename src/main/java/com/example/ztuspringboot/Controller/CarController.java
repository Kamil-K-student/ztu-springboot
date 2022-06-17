package com.example.ztuspringboot.Controller;

import com.example.ztuspringboot.DTO.CarRequest;
import com.example.ztuspringboot.DTO.CarResponse;
import com.example.ztuspringboot.Service.CarServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CarController {

    private final CarServiceImpl carService;

    CarController(final CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping("/car/all")
    public ResponseEntity<List<CarResponse>> getAllCars(){
        List<CarResponse> carResponses = carService.getAllCars();

        return ResponseEntity.ok(carResponses);
    }

    @GetMapping("/car/get/{id}")
    public ResponseEntity<CarResponse> getCar(@PathVariable("id") Integer id){

        return ResponseEntity.ok(carService.getCarById(id));
    }

    @DeleteMapping("car/delete/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable("id") Integer id){

        carService.deleteCar(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("car/post")
    public ResponseEntity <?> addCar(@RequestBody CarRequest carRequest){

        carService.saveCar(carRequest);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("car/put/{id}")
    public ResponseEntity<?> updateCar(@RequestBody CarRequest carRequest){

        if(carService.ifCarExists(carRequest)){
            carService.saveCar(carRequest);

            return  ResponseEntity.noContent().build();
        } else {

            return ResponseEntity.badRequest().build();
        }
    }
}
