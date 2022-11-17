package com.example.crud_car_app.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "car")
    @JsonIgnore
    private CarSpecs carSpecs;

    public Car(){

    }

    public Car(String name, String model, CarSpecs carSpecs) {
        this.brand = name;
        this.model = model;
        this.carSpecs = carSpecs;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String name) {
        this.brand = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public CarSpecs getCarSpecs() {
        return carSpecs;
    }

    public void setCarSpecs(CarSpecs carSpecs) {
        this.carSpecs = carSpecs;
    }
}
