package pl.sda.java.jsp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "jsps", urlPatterns = "/jsp")
public class JSPServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("zmienna", false);
        req.setAttribute("list", Arrays.asList("a", "b", "c", "d"));
        req.getRequestDispatcher("/WEB-INF/jsp.jsp")
                .forward(req, resp);
    }
}
