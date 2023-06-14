package ru.example.servlet;

import ru.example.model.Car;
import ru.example.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UpdateCarServlet extends HttpServlet {

    private Map<Integer, Car> cars;

    @Override
    public void init() throws ServletException {
        final Object cars = getServletContext().getAttribute("cars");

        if(cars == null || !(cars instanceof ConcurrentHashMap)){
            throw new IllegalStateException("Does not initialize!");
        }else {
            this.cars = (ConcurrentHashMap<Integer, Car>) cars;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        final String id = req.getParameter("id");
        final String modelCar = req.getParameter("model");
        final String numberCar = req.getParameter("number");

        final Car car = cars.get(Integer.parseInt(id));
            car.setModelCar(modelCar);
            car.setNumberCar(numberCar);


        resp.sendRedirect(req.getContextPath() + "/");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String id = req.getParameter("id");

        if(Utils.idIsInvalid(id,cars)){
            resp.sendRedirect(req.getContextPath() + "/");
           return;
        }

        final Car car = cars.get(Integer.parseInt(id));
        req.setAttribute("car",car);

        req.getRequestDispatcher("/WEB-INF/view/update.jsp").forward(req,resp);
    }
}
