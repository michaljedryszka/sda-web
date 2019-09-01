package pl.sda.java.jsp.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;

@WebFilter(urlPatterns = "/*")
public class LogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("----------");
        System.out.println(servletRequest);
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        if(req.getCookies() != null){
            Arrays.asList(req.getCookies())
                    .stream()
                    .map(x->x.getName() + " " + x.getValue())
                    .forEach(System.out::println);
        }
        System.out.println("----------");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
