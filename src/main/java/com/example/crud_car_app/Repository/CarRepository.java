package com.example.crud_car_app.Repository;

import com.example.crud_car_app.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findByBrand(String brand);
    List<Car> findByModel(String model);
}
