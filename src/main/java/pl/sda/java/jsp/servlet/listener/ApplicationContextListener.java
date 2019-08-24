package pl.sda.java.jsp.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Przykladowy komponent sledzacy cykl zycia kontenera
 * Jaki jest czas zycia atrybutu ustawionego przy starcie
 */
@WebListener
public class ApplicationContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Inicjalizacja servlet contextu");
        servletContextEvent.getServletContext().setAttribute("contextObject", "Obiekt kontekstu");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Niszczenie servlet contextu");
    }
}
