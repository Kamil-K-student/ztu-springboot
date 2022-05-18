package com.example.ztuspringboot.Controller;

import com.example.ztuspringboot.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    private int i;

    private final CarService carService;

    CarController(final CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars/all")
    public List getAllCars(){
        return carService.getAllCars();

    }

    @GetMapping("/read/cars/{id}")
    void readCar(int id){

    }

    @DeleteMapping("/delete/cars")
    void deleteCar(Integer id){

    }

    @PutMapping("/put/cars/{id}")
    void putCar(Integer id){

    }

    @PostMapping("/post/cars")
    void postCar(){
//        carService.save(car);
    }
}
