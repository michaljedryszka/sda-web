package pl.sda.java.jsp.servlet.kalkulator;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(
        name = "rest-kalkulator",
        urlPatterns = {"/rkalkulator", "/rkalkulator/*"}
)
public class RestKalkulatorServlet extends HttpServlet {
    private Map<Long, Kalkulator> kalkulatory = new HashMap<>();
    private Long id = 0l;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id++;
        Kalkulator kalkulator = new Kalkulator();
        kalkulatory.put(id, kalkulator);
        resp.getWriter().print(id);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String[] uriArray = uri.split("/");
        if (uriArray.length == 6 &&
                uriArray[uriArray.length - 2].equals("wprowadz")) {
            long idKalkulatora = Long.valueOf(uriArray[uriArray.length - 3]);
            String wartosc = uriArray[uriArray.length - 1];
            if (kalkulatory.containsKey(idKalkulatora)) {
                kalkulatory.get(idKalkulatora).wprowadz(wartosc);
                return;
            }
        }
        if (uriArray.length == 5 &&
                uriArray[uriArray.length - 1].equals("dodaj")) {
            long idKalkulatora = Long.valueOf(uriArray[uriArray.length - 2]);
            if (kalkulatory.containsKey(idKalkulatora)) {
                kalkulatory.get(idKalkulatora).dodaj();
                return;
            }
        }
        if (uriArray.length == 5 &&
                uriArray[uriArray.length - 1].equals("wykonaj")) {
            long idKalkulatora = Long.valueOf(uriArray[uriArray.length - 2]);
            if (kalkulatory.containsKey(idKalkulatora)) {
                kalkulatory.get(idKalkulatora).wykonaj();
                return;
            }
        }
        resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String[] uriArray = uri.split("/");
        if (uriArray.length == 5 &&
                uriArray[uriArray.length - 1].equals("wyswietl")) {
            long idKalkulatora = Long.valueOf(uriArray[uriArray.length - 2]);
            if (kalkulatory.containsKey(idKalkulatora)) {
                resp.getWriter().print(kalkulatory.get(idKalkulatora).wyswietl());
                return;
            }
        }
        resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }

    public static void main(String[] args) {
        System.out.println("/web/rkalkulator/1/wyswietl".split("/").length);
    }
}
