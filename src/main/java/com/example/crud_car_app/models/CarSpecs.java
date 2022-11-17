package com.example.crud_car_app.models;


import javax.persistence.*;

@Entity
@Table(name = "carspecs")
public class CarSpecs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column
    private String engine;

    @Column
    private int productionYear;

    @Column
    private String bodyType;

    @Column
    private int km;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="car_id", nullable = false)
    private Car car;

    public CarSpecs(){
    }

    public CarSpecs(String engine, int productionYear, String bodyType, int km) {
        this.engine = engine;
        this.productionYear = productionYear;
        this.bodyType = bodyType;
        this.km = km;
    }


    public void setCar(Car car) {
        this.car = car;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }
}
