package ru.exemple.model;

public class Car {

    private String modelCar;
    private String numberCar;

    public Car(String modelCar, String numberCar) {
        this.modelCar = modelCar;
        this.numberCar = numberCar;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public String getNumberCar() {
        return numberCar;
    }

    public void setNumberCar(String numberCar) {
        this.numberCar = numberCar;
    }

}
