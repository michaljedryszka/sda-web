package pl.sda.java.jsp.servlet.kalkulator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author michaljedryszka
 */
@WebServlet(
        name = "servlet",
        urlPatterns = "/kalkulator"
)
public class KalkulatorServlet extends HttpServlet {

    //private Kalkulator kalkulator = new Kalkulator();

    @Override
    public void doGet(final HttpServletRequest req,
                      final HttpServletResponse resp) throws IOException, ServletException {
        String arg = req.getParameter("arg");
        if(arg == null){
            arg = "";
        }
        Kalkulator kalkulator = (Kalkulator) req.getSession().getAttribute("kalkulator");
        if(kalkulator == null){
            kalkulator = new Kalkulator();
            req.getSession().setAttribute("kalkulator", kalkulator);
        }
        kalkulator.wprowadz(arg);
        req.getRequestDispatcher("kalkulator.jsp").forward(req, resp);
    }

    @Override
    public void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws IOException, ServletException {
        Kalkulator kalkulator = (Kalkulator) req.getSession().getAttribute("kalkulator");
        if(req.getParameter("ce") != null){
            kalkulator.wyczysc();
        }
        if("+".equals(req.getParameter("operator"))){
            kalkulator.dodaj();
        }
        if("-".equals(req.getParameter("operator"))){
            kalkulator.odejmij();
        }
        if(req.getParameter("evaluate") != null){
            kalkulator.wykonaj();
        }
        req.getRequestDispatcher("kalkulator.jsp").forward(req, resp);
    }
}
