package com.example.crud_car_app.Repository;

import com.example.crud_car_app.models.CarSpecs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CarSpecsRepository extends JpaRepository<CarSpecs, Integer> {
    @Transactional
    void deleteById(int id);

    @Transactional
    void deleteByCarId(int carId);
}
