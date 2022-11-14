package com.example.crud_car_app.Services;

import com.example.crud_car_app.Repository.CarSpecsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarSpecsService {

    @Autowired
    private CarSpecsRepository carSpecsRepository;


}
