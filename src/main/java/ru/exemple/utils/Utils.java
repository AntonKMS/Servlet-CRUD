package ru.exemple.utils;

import ru.exemple.model.Car;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class Utils {

    public static boolean idIsNumber(HttpServletRequest req){
        final String id = req.getParameter("id");

        return id != null && (id.length() > 0) && id.matches("[+]?\\d+");
    }

    public static boolean requestIsValid(final HttpServletRequest req){
        final String modelCar = req.getParameter("model");
        final String numberCar = req.getParameter("number");

        return modelCar != null && modelCar.length() > 0
                && numberCar != null && numberCar.length() > 0;// && modelCar.matches("[+]?\\d+");
    }

    public static Car createCar(final int id, final String modelCar,final String numberCar) {
        Car car = new Car();
        car.setId(id);
        car.setModelCar(modelCar);
        car.setNumberCar(numberCar);
        return car;
    }

    public static boolean idIsInvalid(final String id, Map<Integer, Car> repo){
        return !(id != null && id.matches("[+]?\\d+") && repo.get(Integer.parseInt(id)) != null);
    }
}
