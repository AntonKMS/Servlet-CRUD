package ru.exemple.model;

public class Parking {

    private Integer parkingSpace;
    private String modelCar;

    public Parking(Integer parkingSpace, String modelCar) {
        this.parkingSpace = parkingSpace;
        this.modelCar = modelCar;
    }

    public Integer getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(Integer parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

}
