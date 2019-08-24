package pl.sda.java.jsp.servlet.nav;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Uzycie forward
 * Strumien wyjsciowy zostaje zamkniety
 */
@WebServlet(name="forward", urlPatterns = "/forward")
public class ForwardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("<p>Forward to target</p>");
        req.setAttribute("Ustawiony w forward", "forward");
        req.getRequestDispatcher("/navtarget").forward(req, resp);
    }
}
