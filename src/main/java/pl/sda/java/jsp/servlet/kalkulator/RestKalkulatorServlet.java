package pl.sda.java.jsp.servlet.kalkulator;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(
        name = "rest-kalkulator",
        urlPatterns = {"/rkalkulator", "/rkalkulator/*"}
)
public class RestKalkulatorServlet extends HttpServlet {
    private Map<Long, Kalkulator> kalkulatory = new HashMap<>();
    private Map<Long, Long> znacznikiCzasu = new HashMap<>();
    private Thread watekSprzatajacy;
    private Long id = 0l;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id++;
        Kalkulator kalkulator = new Kalkulator();
        kalkulatory.put(id, kalkulator);
        znacznikiCzasu.put(id, new Date().getTime());
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
                getKalkulator(idKalkulatora).wprowadz(wartosc);
                return;
            }
        }
        if (uriArray.length == 5 &&
                uriArray[uriArray.length - 1].equals("dodaj")) {
            long idKalkulatora = Long.valueOf(uriArray[uriArray.length - 2]);
            if (kalkulatory.containsKey(idKalkulatora)) {
                getKalkulator(idKalkulatora).dodaj();
                return;
            }
        }
        if (uriArray.length == 5 &&
                uriArray[uriArray.length - 1].equals("wykonaj")) {
            long idKalkulatora = Long.valueOf(uriArray[uriArray.length - 2]);
            if (kalkulatory.containsKey(idKalkulatora)) {
                getKalkulator(idKalkulatora).wykonaj();
                return;
            }
        }
        resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }

    private Kalkulator getKalkulator(long idKalkulatora) {
        znacznikiCzasu.put(idKalkulatora, new Date().getTime());
        return kalkulatory.get(idKalkulatora);
    }

    private void sprzatanie(){
        Long chwilaObecna = new Date().getTime();
        List<Long> idDusuniecia = new ArrayList();
        for(Map.Entry<Long, Long> znacznik : znacznikiCzasu.entrySet()){
            if( chwilaObecna - znacznik.getValue() > 10 * 1000){
                kalkulatory.remove(znacznik.getKey());
                idDusuniecia.add(znacznik.getKey());
                System.out.println("Usuwam: " + znacznik.getKey());
            }
        }
        idDusuniecia.stream().forEach(znacznikiCzasu::remove);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String[] uriArray = uri.split("/");
        if (uriArray.length == 5 &&
                uriArray[uriArray.length - 1].equals("wyswietl")) {
            long idKalkulatora = Long.valueOf(uriArray[uriArray.length - 2]);
            if (kalkulatory.containsKey(idKalkulatora)) {
                resp.getWriter().print(getKalkulator(idKalkulatora).wyswietl());
                return;
            }
        }
        resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }

    @Override
    public void init() throws ServletException {
        watekSprzatajacy = new Thread(() -> {
            while(true){
                System.out.println("Sprzatam");
                sprzatanie();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        });
        watekSprzatajacy.start();
    }

    @Override
    public void destroy() {
        watekSprzatajacy.interrupt();
    }

    public static void main(String[] args) {
        System.out.println("/web/rkalkulator/1/wyswietl".split("/").length);
    }
}
