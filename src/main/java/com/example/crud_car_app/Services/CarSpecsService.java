package com.example.crud_car_app.Services;

import com.example.crud_car_app.Repository.CarRepository;
import com.example.crud_car_app.Repository.CarSpecsRepository;
import com.example.crud_car_app.models.Car;
import com.example.crud_car_app.models.CarSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarSpecsService {

    @Autowired
    private CarSpecsRepository carSpecsRepository;
    @Autowired
    private CarRepository carRepository;
    public CarSpecs saveCarSpecs(int carId, CarSpecs carSpecs){
        Car car = carRepository.findById(carId).orElse(null);
        carSpecs.setCar(car);
        return carSpecsRepository.save(carSpecs);
    }

}
