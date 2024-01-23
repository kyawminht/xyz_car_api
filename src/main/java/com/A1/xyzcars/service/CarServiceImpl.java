package com.A1.xyzcars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.A1.xyzcars.entity.Car;
import com.A1.xyzcars.entity.User;
import com.A1.xyzcars.repo.CarRepository;
import com.A1.xyzcars.repo.UserRepository;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Car> searchCars(String make, String model, String registration, Double minPrice, Double maxPrice) {
        // Handle null values for minPrice and maxPrice
        double minPriceValue = (minPrice != null) ? minPrice.doubleValue() : Double.MIN_VALUE;
        double maxPriceValue = (maxPrice != null) ? maxPrice.doubleValue() : Double.MAX_VALUE;

        return carRepository.findByMakeContainingAndModelContainingAndRegistrationContainingAndPriceBetween(
                make, model, registration, minPriceValue, maxPriceValue);
    }
    
    @Override
public Car getCarById(Long id) {
    return carRepository.findById(id).orElse(null);
}


    @Override
    public Car saveCar(Car car, String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            car.setUser(user);
            return carRepository.save(car);
        } else {
            // Handle the case when the user is not found
            return null;
        }
    }
}

