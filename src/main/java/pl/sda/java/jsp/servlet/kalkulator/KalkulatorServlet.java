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

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        if(session.getAttribute("kalkulator") == null){
            session.setAttribute("kalkulator", new Kalkulator());
        }
        Kalkulator kalkulator = (Kalkulator) session.getAttribute("kalkulator");

        String arg = req.getParameter("arg");
        if (arg == null) {
            arg = "";
        }
        kalkulator.przyjmijWartoscArgumentu(arg);
        req.getRequestDispatcher("kalkulator.jsp").forward(req, resp);
    }

    @Override
    public void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws IOException, ServletException {
        Kalkulator kalkulator = (Kalkulator) req.getSession().getAttribute("kalkulator");
        if (req.getParameter("ce") != null) {
            kalkulator.resetuj();
        }
        if (req.getParameter("operator") != null) {
            kalkulator.ustawOperator(req.getParameter("operator"));
        }
        if (req.getParameter("evaluate") != null) {
            kalkulator.oblicz();
        }
        req.getRequestDispatcher("kalkulator.jsp").forward(req, resp);
    }
}
