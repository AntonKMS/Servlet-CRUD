package ru.example.servlet;

import ru.example.model.Car;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GetIndexServlet extends HttpServlet {

    private Map<Integer,Car> cars;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cars",cars.values());
        req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req,resp);
    }

}
