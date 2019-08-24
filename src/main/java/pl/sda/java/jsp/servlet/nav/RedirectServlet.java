package pl.sda.java.jsp.servlet.nav;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Przykladowy redirect
 */
@WebServlet(name = "redirect", urlPatterns = "/redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("<p>Redirect target</p>");
        req.setAttribute("Ustawiony w redirect", "redirect");
        resp.sendRedirect("navtarget");
    }
}
