package ru.example.servlet;

import ru.example.model.Car;
import ru.example.utils.Utils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebListener
public class ContextLister implements ServletContextListener {

    private Map<Integer, Car> cars;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        final ServletContext servletContext = sce.getServletContext();

        cars = new ConcurrentHashMap<>();
        servletContext.setAttribute("cars",cars);

        final Car car = Utils.createCar(1,"Nissan","В558НР27");
        this.cars.put(car.getId(),car);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        cars = null;
    }
}
