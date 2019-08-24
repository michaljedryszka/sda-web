package pl.sda.java.jsp.servlet;

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
        name = "servlet500",
        urlPatterns = {"/servlet500"}
)
public class Servlet500 extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        throw new RuntimeException("Runtime exception");
    }
}
