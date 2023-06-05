package ru.exemple.servlet;

import ru.exemple.model.Car;
import ru.exemple.utils.Utils;

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

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        cars = null;
    }
}
