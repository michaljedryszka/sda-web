package pl.sda.java.jsp.servlet.nav;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Servlet docelowy
 */

@WebServlet(urlPatterns = "/navtarget", name = "navtarget")
public class NavTargetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write("<p>Naw target servlet</p>");
        Enumeration<String> attributeNames = req.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            resp.getWriter().write(String.format("<p>Attributes: %s</p>", attributeNames.nextElement()));
        }
    }
}
