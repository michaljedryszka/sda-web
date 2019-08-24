package pl.sda.java.jsp.servlet.scope;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author michaljedryszka
 */
@WebServlet(
        name = "attributeget",
        urlPatterns = {"/attributeget"}
)
public class AttributeGetterServlet extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        if (req.getAttribute("request") != null) {
            resp.getWriter().write(req.getAttribute("request").toString());
        }
        if (req.getSession().getAttribute("session") != null) {
            resp.getWriter().write(req.getSession().getAttribute("session").toString());
        }
        if (getServletContext().getAttribute("context") != null) {
            resp.getWriter().write(getServletContext().getAttribute("context").toString());
        }
    }
}
