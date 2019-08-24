package pl.sda.java.jsp.servlet.listener;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Odczyt atrybutu z kontekstu
 */
@WebServlet(name = "listener", urlPatterns = "/listener")
public class ListenerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write(getServletContext().getAttribute("contextObject").toString());
    }
}
