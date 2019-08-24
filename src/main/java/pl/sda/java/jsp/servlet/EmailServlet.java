package pl.sda.java.jsp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet(
        name="email",
        urlPatterns = "/email"
)
public class EmailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("email.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        if(pattern.matcher(req.getParameter("email")).matches()){
            req.getSession().setAttribute("email",
                    req.getParameter("email"));
            resp.sendRedirect("kalkulator");
        } else {
            //komunikat
            req.setAttribute("komunikat", "Niepoprawny email");
            req.getRequestDispatcher("email.jsp").forward(req, resp);
        }
    }
}
