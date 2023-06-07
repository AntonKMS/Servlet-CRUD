package ru.exemple.servlet;

import ru.exemple.model.Car;
import ru.exemple.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DeleteCarServlet extends HttpServlet {
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

        if(Utils.idIsNumber(req)){

            cars.remove(Integer.parseInt(req.getParameter("id")));
        }
        resp.sendRedirect(req.getContextPath() + "/");
    }
}
