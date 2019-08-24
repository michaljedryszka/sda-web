package pl.sda.java.jsp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "simplePage", urlPatterns = "/simplePage")
public class SimplePage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("testAttribute", "Test value");
        req.getRequestDispatcher("jsp/simplePage.jsp").forward(req, resp);
    }
}
