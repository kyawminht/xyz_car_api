package com.A1.xyzcars.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.A1.xyzcars.entity.Car;
import com.A1.xyzcars.service.CarService;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;


    @GetMapping("/search")
    public ResponseEntity<List<Car>> searchCars(@RequestParam Map<String, String> params) {
        // Now 'params' contains all query parameters, and you can use them as needed

        // Extract parameters dynamically and use partial matching
        String make = params.get("make");
        String model = params.get("model");
        String registration = params.get("registration");
        String minPriceStr = params.get("minPrice");
        String maxPriceStr = params.get("maxPrice");

        // Convert string values to double (handle conversion errors as needed)
        Double minPrice = (minPriceStr != null) ? Double.parseDouble(minPriceStr) : null;
        Double maxPrice = (maxPriceStr != null) ? Double.parseDouble(maxPriceStr) : null;

        // Perform partial matching for string parameters
        List<Car> cars = carService.searchCars(
                make != null ? "%" + make + "%" : null,
                model != null ? "%" + model + "%" : null,
                registration != null ? "%" + registration + "%" : null,
                minPrice,
                maxPrice
        );

        return ResponseEntity.ok(cars);
    }

    @PostMapping("/post")
    public ResponseEntity<Car> postCar(@RequestBody Car car, @RequestParam String username) {
        Car savedCar = carService.saveCar(car, username);
        return ResponseEntity.ok(savedCar);
    }

    @GetMapping("/{id}")
public ResponseEntity<Car> getCarById(@PathVariable Long id) {
    Car car = carService.getCarById(id);

    if (car != null) {
        return ResponseEntity.ok(car);
    } else {
        return ResponseEntity.notFound().build();
    }
}

}

