package pl.sda.java.jsp.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Przykladowy filtr
 * Filtry wykonuja sie przed service w servlecie
 * Filtrow moze byc kilka, wykonuja sie jeden po drugim
 * @author michaljedryszka
 */
public class XmlFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Inicjalizacja filtra");
        Enumeration<String> initParams = filterConfig.getInitParameterNames();
        while (initParams.hasMoreElements()) {
            String paramName = initParams.nextElement();
            System.out.println("Init filtra: " + paramName + ": "+ filterConfig.getInitParameter(paramName));
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setAttribute("setintfilter", "Wartosc ustawiona w filtrze");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("Sprzatanie filtra");
    }
}
