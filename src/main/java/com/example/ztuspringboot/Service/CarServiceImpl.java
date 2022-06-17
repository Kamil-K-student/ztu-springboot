package com.example.ztuspringboot.Service;

import com.example.ztuspringboot.CarServiceImpl.CarService;
import com.example.ztuspringboot.DTO.CarRequest;
import com.example.ztuspringboot.DTO.CarResponse;
import com.example.ztuspringboot.Entity.Car;
import com.example.ztuspringboot.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    CarServiceImpl(CarRepository carRepository) {

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

    public CarResponse getCarById(Integer id){

        Car entity = carRepository.findById(id).get();

        return new CarResponse(entity.getId(), entity.getBrand(), entity.getModel());
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

    public boolean ifCarExists(CarRequest carRequest){

        int id = carRequest.getId();

        return carRepository.existsById(id);
    }
}
