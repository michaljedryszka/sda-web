package pl.sda.java.jsp.servlet.nav;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Uzycie include
 */
@WebServlet(name = "include", urlPatterns = "/include")
public class IncludeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("<p>Include target</p>");
        req.setAttribute("Ustawiony w include", "include");
        req.getRequestDispatcher("/navtarget").include(req, resp);
    }
}
