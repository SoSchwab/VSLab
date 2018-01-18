package com.fancyapp.fancy;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car {

    @Id
    @GeneratedValue
    private Long id;
    private String licensePlate;
    private String brand;

    public Car(){}

    public Car(String licensePlate, String brand){
        this.licensePlate = licensePlate;
        this.brand = brand;


    }

    /*@Override
    public String toString(){
        return String.format("Car [licensePlate='%s', brand='%s']", licensePlate, brand);
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate){
        this.licensePlate=licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
