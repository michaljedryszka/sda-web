package pl.sda.java.jsp.kino;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "listaFilmow", urlPatterns = "/kino/listaFilmow")
public class ListaFilmow extends HttpServlet {

    private IObslugaFilmow obslugaFilmow;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String miasto = req.getParameter("miasto");
        LocalDate data = null;
        if(req.getParameter("data") != null){
            data = LocalDate.parse(req.getParameter("data"), DateTimeFormatter.ISO_LOCAL_DATE);
        }
        List<Film> filmy = obslugaFilmow.listaFilmow(miasto, data);
        req.setAttribute("filmy", filmy);
        req.getRequestDispatcher("listaFilmow.jsp").forward(req, resp);
    }

    @Override
    public void init() throws ServletException {
         obslugaFilmow = new ObslugaFilmowZNPE();
    }
}
