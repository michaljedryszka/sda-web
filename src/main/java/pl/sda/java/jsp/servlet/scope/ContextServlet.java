package pl.sda.java.jsp.servlet.scope;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Użycie kontekstu
 */
@WebServlet(
        name = "contextservlet",
        urlPatterns = {"/contextservlet"}
)
public class ContextServlet extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("Parametry kontekstu aplikacji:");
        final Enumeration<String> parameterNames = getServletContext().getInitParameterNames();
        while(parameterNames.hasMoreElements()){
            String paramName = parameterNames.nextElement();
            resp.getWriter().print(paramName + ": " + getServletContext().getInitParameter(paramName));
        }
    }
}
