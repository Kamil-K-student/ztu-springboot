package com.example.ztuspringboot;

import com.example.ztuspringboot.Controller.CarController;
import com.example.ztuspringboot.DTO.CarRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class ZtuSpringbootApplicationTests {
	@Autowired
	private CarController carController;
//	@Test
//	void contextLoads() {
//	}
//
//	@Test
//	void addCar(){
//		CarRequest carRequest = new CarRequest();
//		carRequest.setBrand("Ford");
//		carRequest.setModel("Mondeo");
//		carController.addCar(carRequest);
//
//	}
//
//	@Test
//	void deleteCar(){
//		carController.deleteCar(3);
//	}
//
//	@Test
//	void getCar(){
//		ResponseEntity<?> v =  carController.getCar(3);
//		System.out.println(v);
//	}


}
