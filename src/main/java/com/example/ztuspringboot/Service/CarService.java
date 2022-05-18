package com.example.ztuspringboot.Service;

import com.example.ztuspringboot.DTO.CarRequest;
import com.example.ztuspringboot.DTO.CarResponse;
import com.example.ztuspringboot.Entity.Car;
import com.example.ztuspringboot.Repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CarService {

    private final CarRepository carRepository;

    CarService(final CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarResponse> getAllCars(){
        return StreamSupport.stream(carRepository.findAll().spliterator(), false)
                .map(entity -> new CarResponse(entity.getId(), entity.getBrand(), entity.getModel()))
                .collect(Collectors.toList());
    }

    public Object getById(Integer id){
        if (!carRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return carRepository.findById(id).get();
        }
    }

    public void save(CarRequest carRequest){
        Car car = new Car();
        car.setId(carRequest.getId());
        car.setBrand(carRequest.getBrand());
        car.setModel(carRequest.getModel());
        carRepository.save(car);
    }

    public void delete(Integer id){
        carRepository.deleteById(id);
    }

    public void update(CarRequest carRequest){
        Car car = new Car();
        car.setId(carRequest.getId());
        car.setBrand(carRequest.getBrand());
        car.setModel(carRequest.getModel());
        carRepository.save(car);
    }
}
