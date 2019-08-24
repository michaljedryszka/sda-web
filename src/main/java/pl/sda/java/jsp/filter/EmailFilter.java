package pl.sda.java.jsp.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(
        urlPatterns = "/kalkulator"
)
public class EmailFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        if(1<2){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        if (servletRequest instanceof HttpServletRequest &&
                servletResponse instanceof HttpServletResponse) {
            HttpServletRequest req = (HttpServletRequest) servletRequest;
            HttpServletResponse resp = (HttpServletResponse) servletResponse;
            if (req.getSession().getAttribute("email") != null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                resp.sendRedirect("email.jsp");
                //req.getRequestDispatcher("email.jsp").forward(req, resp);
            }
        }
        servletResponse.getWriter().print("Nieprawidlowe zadanie");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
