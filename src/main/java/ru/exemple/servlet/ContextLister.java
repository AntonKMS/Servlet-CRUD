package ru.exemple.servlet;

import ru.exemple.model.Car;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebListener
public class ContextLister implements ServletContextListener {

    private Map<Integer, Car> parkingMap;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        final ServletContext servletContext = sce.getServletContext();

        parkingMap = new ConcurrentHashMap<>();
        servletContext.setAttribute("parking",parkingMap);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        parkingMap = null;
    }
}
