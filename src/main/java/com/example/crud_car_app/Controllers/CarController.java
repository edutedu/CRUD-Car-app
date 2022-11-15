package com.example.crud_car_app.Controllers;

import com.example.crud_car_app.Services.CarService;
import com.example.crud_car_app.Services.CarSpecsService;
import com.example.crud_car_app.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/addCar")
    public Car addCar(@RequestBody Car car){
        return carService.saveCar(car);
    }

    @PostMapping("/addCars")
    public List<Car> addCars(@RequestBody List<Car> cars){
        return carService.saveCars(cars);
    }

    @GetMapping("/getcars")
    public List<Car> findCars(){
        return carService.getCars();
    }

    @GetMapping( "/car/{id}")
    public Car findCarById(@PathVariable int id){
        return carService.getCarById(id);
    }

    @GetMapping("/getCarsByBrand/{brand}")
    public List<Car> findCarsByBrand(@PathVariable(value="brand") String brand) {
        return carService.getCarByBrand(brand);
    }


    @GetMapping("/getCarsByModel/{model}")
    public List<Car> findCarsByModel(@PathVariable(value = "model") String model){
        return carService.getCarByModel(model);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCar(@PathVariable int id){
        return carService.deleteCar(id);
    }

    @PutMapping("/update/{id}")
    public Car updateCar(@PathVariable int id, @RequestBody Car car){
        return carService.updateCar(id, car);
    }

}
