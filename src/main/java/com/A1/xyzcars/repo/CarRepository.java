package com.A1.xyzcars.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.A1.xyzcars.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT c FROM Car c WHERE " +
    "(:make IS NULL OR c.make LIKE %:make%) AND " +
    "(:model IS NULL OR c.model LIKE %:model%) AND " +
    "(:registration IS NULL OR c.registration LIKE %:registration%) AND " +
    "(:minPrice IS NULL OR c.price >= :minPrice) AND " +
    "(:maxPrice IS NULL OR c.price <= :maxPrice)")
    List<Car> findByMakeContainingAndModelContainingAndRegistrationContainingAndPriceBetween(
        String make, String model, String registration, double minPrice, double maxPrice);



}


