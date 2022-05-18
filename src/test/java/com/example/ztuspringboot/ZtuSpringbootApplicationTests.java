package com.example.ztuspringboot;

import com.example.ztuspringboot.Entity.Car;
import com.example.ztuspringboot.Service.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ZtuSpringbootApplicationTests {
	@Autowired
	private CarService carService;
	@Test
	void contextLoads() {
	}

	@Test
	void addCar(){
		Car car = new Car();
		car.setId(3);
		car.setBrand("Toyota");
		car.setModel("Yaris");
		carService.save(car);

	}

}
