package com.example.crud_car_app.Services;

import com.example.crud_car_app.Repository.CarRepository;
import com.example.crud_car_app.Repository.CarSpecsRepository;
import com.example.crud_car_app.models.Car;
import com.example.crud_car_app.models.CarSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public CarSpecs getCarSpecsById(int id){
        return carSpecsRepository.findById(id).orElse(null);
    }

    public List<CarSpecs> getCarSpecs(){
        return carSpecsRepository.findAll();
    }

    public CarSpecs updateCarSpecs(int id, CarSpecs carSpecs){
        CarSpecs existingCarSpecs = carSpecsRepository.findById(id).orElse(null);
        assert existingCarSpecs != null;
        if(carSpecs.getKm()!=0 && existingCarSpecs.getKm()<=carSpecs.getKm()){
            existingCarSpecs.setKm(carSpecs.getKm());
        }
        if(carSpecs.getEngine() != null){
            existingCarSpecs.setEngine(carSpecs.getEngine());
        }
        return carSpecsRepository.save(existingCarSpecs);
    }

    public String deleteCarSpecsById(int id){
        carSpecsRepository.deleteById(id);
        return "The car specifications wit the id: " + id + " has been deleted";
    }

    public String deleteCarSpecsByCarId(int carId){
        if(!carSpecsRepository.existsById(carId)){
            return "Not found the car with the id = " + carId;
        }
        carSpecsRepository.deleteByCarId(carId);
        return "The car specifications of the car with the id: " + carId + " has been deleted";
    }

}
