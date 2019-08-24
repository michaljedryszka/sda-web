package pl.sda.java.jsp.servlet.scope;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "attributeset",
        urlPatterns = {"/attributeset"}
)
public class AttributeSetterServlet extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("request", "request attribute");
        req.getSession().setAttribute("session", "session attribute");
        getServletContext().setAttribute("context", "context attribute");
    }
}
