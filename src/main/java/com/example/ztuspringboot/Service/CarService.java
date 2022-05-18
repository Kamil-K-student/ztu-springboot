package com.example.ztuspringboot.Service;

import com.example.ztuspringboot.Entity.Car;
import com.example.ztuspringboot.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    CarService(final CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars(){
        List<Car> cars = new ArrayList<>();
        Streamable.of(carRepository.findAll())
                .forEach(cars::add);
        carRepository.findAll();
        return cars;
    }

    public Object getById(Integer id){
        if (!carRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return carRepository.findById(id);
        }
    }

    public void save(Car car){
        carRepository.save(car);
    }

    public void delete(Car car){
        carRepository.delete(car);
    }

    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Car car, String model){
        if (!carRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            car.setModel(model);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
