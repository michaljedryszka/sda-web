package pl.sda.java.jsp.servlet.filter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Zwroc uwage na deklaracje urlPatterns w filtrze i servlecie
 */
@WebServlet(
        name = "filterdeeper",
        urlPatterns = "/filter/deeper"
)
public class DeeperFilterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write(req.getAttribute("setintfilter").toString());
    }
}
