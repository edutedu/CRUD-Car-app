package com.example.crud_car_app.Services;

import com.example.crud_car_app.Repository.CarRepository;
import com.example.crud_car_app.Repository.CarSpecsRepository;
import com.example.crud_car_app.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarSpecsRepository carSpecsRepository;

    public Car saveCar(Car car){
        return carRepository.save(car);
    }

    public List<Car> saveCars(List<Car> cars){
        return carRepository.saveAll(cars);
    }

    public Car getCarById(int id){
        return carRepository.findById(id).orElse(null);
    }

    public List<Car> getCars(){
        return carRepository.findAll();
    }

    public List<Car> getCarByBrand(String brand){
        return carRepository.findByBrand(brand);
    }

    public List<Car> getCarByModel(String model){
        return carRepository.findByModel(model);
    }

    public String deleteCar(int id){
        if(carSpecsRepository.existsById(id)){
            carSpecsRepository.deleteById(id);
        }
        carRepository.deleteById(id);
        return "Car with the id:" + id +" has been deleted";
    }

    public Car updateCar(int id, Car car){
        Car existingCar = carRepository.findById(id).orElse(null);
        assert existingCar != null;
        if(car.getBrand()!= null){
            existingCar.setBrand(car.getBrand());
        }
        if(car.getModel() != null){
            existingCar.setModel(car.getModel());
        }

        return carRepository.save(existingCar);
    }
}
