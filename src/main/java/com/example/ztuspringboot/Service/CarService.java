package com.example.ztuspringboot.Service;

import com.example.ztuspringboot.CarServiceImpl.CarServiceImpl;
import com.example.ztuspringboot.DTO.CarRequest;
import com.example.ztuspringboot.DTO.CarResponse;
import com.example.ztuspringboot.Entity.Car;
import com.example.ztuspringboot.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarService implements CarServiceImpl {

    private final CarRepository carRepository;

    @Autowired
    CarService(CarRepository carRepository) {

        this.carRepository = carRepository;
    }

    public List<CarResponse> getAllCars() {

        List<Car> carList;
        List<CarResponse> carResponses = new ArrayList<>();
        carList = carRepository.findAll();

        for(Car entity : carList){
            CarResponse carResponse = new CarResponse(entity.getId(), entity.getBrand(), entity.getModel());
            carResponses.add(carResponse);
        }

        return carResponses;
    }

    public Car getCarById(Integer id){

            return carRepository.findById(id).get();
    }

    public void saveCar(CarRequest carRequest){
        Car car = new Car();
        car.setId(carRequest.getId());
        car.setBrand(carRequest.getBrand());
        car.setModel(carRequest.getModel());
        carRepository.save(car);
    }

    public void deleteCar(Integer id){
        carRepository.deleteById(id);
    }

    public void updateCar(CarRequest carRequest){
        Car car = new Car();
        car.setId(carRequest.getId());
        car.setBrand(carRequest.getBrand());
        car.setModel(carRequest.getModel());
        carRepository.save(car);
    }
}
