package com.example.ztuspringboot.CarServiceImpl;

import com.example.ztuspringboot.DTO.CarRequest;
import com.example.ztuspringboot.DTO.CarResponse;

import java.util.List;

public interface CarService {

    List<CarResponse> getAllCars();
    CarResponse getCarById(Integer id);
    void saveCar(CarRequest carRequest);
    void deleteCar(Integer id);
}


