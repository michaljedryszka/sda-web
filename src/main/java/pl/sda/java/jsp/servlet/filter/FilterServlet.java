package pl.sda.java.jsp.servlet.filter;

/**
 * @author michaljedryszka
 */

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet poprzedzony filtrem
 * Zwroc uwage w ktorym miejscy ustawiana sa parametry odczytywane w servlecie
 */
@WebServlet(
        name="filter",
        urlPatterns = "/filter"
)
public class FilterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write(req.getAttribute("setintfilter").toString());
    }
}
