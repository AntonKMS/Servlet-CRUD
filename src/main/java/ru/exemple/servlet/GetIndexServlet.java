package ru.exemple.servlet;

import com.sun.deploy.net.HttpRequest;
import ru.exemple.model.Parking;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GetIndexServlet extends HttpServlet {

    private List<Parking> listCar;

    @Override
    public void init() throws ServletException {
        listCar = new CopyOnWriteArrayList<>();
        listCar.add(new Parking(1,"Toyota Corolla"));
        listCar.add(new Parking(2,"Suzuki Escudo"));
        listCar.add(new Parking(3,"Nissan Juke"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cars",listCar);
        req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        if(!requestIsValid(req)){
            doGet(req,resp);
        }

        final String parkingSpace = req.getParameter("place");
        final String modelCar = req.getParameter("car");

        listCar.add(new Parking(Integer.parseInt(parkingSpace),modelCar));
        doGet(req,resp);
    }

    private boolean requestIsValid(final HttpServletRequest req){
        final String parkingSpace = req.getParameter("place");
        final String modelCar = req.getParameter("car");

        return parkingSpace != null && parkingSpace.length() > 0 && parkingSpace.matches("[+]?\\d+")
                    && modelCar != null && modelCar.length() > 0;
    }
}
