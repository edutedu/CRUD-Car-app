package com.example.crud_car_app.Controllers;

import com.example.crud_car_app.Services.CarSpecsService;
import com.example.crud_car_app.models.CarSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CarSpecsController {
    @Autowired
    private CarSpecsService carSpecsService;

    @PostMapping("/cars/{carId}/addCarSpecs")
    public CarSpecs addCarSpecs(@PathVariable int carId, @RequestBody CarSpecs carSpecs){
        return carSpecsService.saveCarSpecs(carId, carSpecs);
    }

    @GetMapping("/carSpecs/{id}")
    public CarSpecs findCarSpecsById(@PathVariable int id){
        return carSpecsService.getCarSpecsById(id);
    }

    @GetMapping("/getCarsSpecs")
    public List<CarSpecs> findCarSpecs(){
        return carSpecsService.getCarSpecs();
    }

    @PutMapping("/carSpecs/update/{id}")
    public CarSpecs updateCarSpecs(@PathVariable int id, @RequestBody CarSpecs carSpecs){
        return carSpecsService.updateCarSpecs(id, carSpecs);
    }

    @DeleteMapping("/carSpecs/delete/{id}")
    public String deleteCarSpecsById(@PathVariable int id){
        return carSpecsService.deleteCarSpecsById(id);
    }

    @DeleteMapping("/cars/{carId}/carSpecs/delete")
    public String deleteCarSpecsByCarId(@PathVariable int carId){
        return carSpecsService.deleteCarSpecsByCarId(carId);
    }

}
