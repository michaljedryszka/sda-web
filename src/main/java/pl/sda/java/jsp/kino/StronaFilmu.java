package pl.sda.java.jsp.kino;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "stronaFilmu", urlPatterns = "/kino/stronaFilmu")
public class StronaFilmu extends HttpServlet {

    private ObslugaFilmow obslugaFilmow;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idFilmu = Integer.valueOf(req.getParameter("idFilmu"));
        Film film = obslugaFilmow.film(idFilmu);
        List<Kino> listaKin = obslugaFilmow.listaKin(idFilmu);
        req.setAttribute("film", film);
        req.setAttribute("listaKin", listaKin);
        req.getRequestDispatcher("stronaFilmu.jsp").forward(req, resp);
    }

    @Override
    public void init() throws ServletException {
        obslugaFilmow = new ObslugaFilmow();
    }
}
