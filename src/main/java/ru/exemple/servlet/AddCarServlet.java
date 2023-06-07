package ru.exemple.servlet;

import ru.exemple.model.Car;
import ru.exemple.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

//@WebServlet(urlPatterns = "/add")
public class AddCarServlet extends HttpServlet {
    private Map<Integer, Car> cars;
    private AtomicInteger id;

    @Override
    public void init() throws ServletException {
        final Object cars = getServletContext().getAttribute("cars");

        if(cars == null || !(cars instanceof ConcurrentHashMap)){
            throw new IllegalStateException("Does not initialize!");
        }else {
            this.cars = (ConcurrentHashMap<Integer, Car>) cars;
        }
        id = new AtomicInteger(2);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        if(Utils.requestIsValid(req)){
            final String modelCar = req.getParameter("model");
            final String numberCar = req.getParameter("number");

            final int id = this.id.getAndIncrement();
            final Car car = new Car(modelCar,numberCar);
            cars.put(id,car);
        }

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
