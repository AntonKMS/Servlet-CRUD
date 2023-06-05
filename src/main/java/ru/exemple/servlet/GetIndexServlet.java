package ru.exemple.servlet;

import ru.exemple.model.Car;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GetIndexServlet extends HttpServlet {

    private List<Car> listCar;

    @Override
    public void init() throws ServletException {
        listCar = new CopyOnWriteArrayList<>();
        listCar.add(new Car("Toyota Corolla","B302НП27"));
        listCar.add(new Car("Nissan Juke","В558НТ27"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cars",listCar);
        req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        if(requestIsValid(req)){
            final String modelCar = req.getParameter("model");
            final String numberCar = req.getParameter("number");

            listCar.add(new Car(modelCar,numberCar));
            doGet(req,resp);
        }


        doGet(req,resp);
    }

    private boolean requestIsValid(final HttpServletRequest req){
        final String modelCar = req.getParameter("model");
        final String numberCar = req.getParameter("number");

        return modelCar != null && modelCar.length() > 0
                    && numberCar != null && numberCar.length() > 0;// && modelCar.matches("[+]?\\d+");
    }
}
