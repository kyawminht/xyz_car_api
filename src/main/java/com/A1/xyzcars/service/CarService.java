package com.A1.xyzcars.service;

import java.util.List;

import com.A1.xyzcars.entity.Car;

public interface CarService {
    
    Car saveCar(Car car, String username);
    Car getCarById(Long id);
    List<Car> searchCars(String make, String model, String registration, Double minPrice, Double maxPrice);
}
