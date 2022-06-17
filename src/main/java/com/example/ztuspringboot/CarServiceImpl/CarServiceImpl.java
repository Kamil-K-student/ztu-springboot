package com.example.ztuspringboot.CarServiceImpl;

import com.example.ztuspringboot.DTO.CarRequest;
import com.example.ztuspringboot.DTO.CarResponse;
import com.example.ztuspringboot.Entity.Car;
import java.util.List;

public interface CarServiceImpl {

    List<CarResponse> getAllCars();
    Car getCarById(Integer id);
    void saveCar(CarRequest carRequest);
    void updateCar(CarRequest carRequest);
    void deleteCar(Integer id);
}


