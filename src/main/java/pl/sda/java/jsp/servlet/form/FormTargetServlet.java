package pl.sda.java.jsp.servlet.form;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author michaljedryszka
 */
@WebServlet(
        name = "formtarget",
        urlPatterns = {"/formtarget"}
)
public class FormTargetServlet extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {
        String page = "<html>";
        page += "<p> metoda: " + req.getMethod() + "</p>";
        final Enumeration<String> parameternames = req.getParameterNames();
        while (parameternames.hasMoreElements()) {
            final String parameterName = parameternames.nextElement();
            final String[] tablicaWartosci = req.getParameterValues(parameterName);
            page += "<p> parametr: " + parameterName + "; wartosc: "
                    + tablicaDoString(tablicaWartosci) + "</p>";
        }
        page += "</html>";
        resp.getWriter().write(page);
    }

    private String tablicaDoString(String[] tablica) {
        StringBuilder wynik = new StringBuilder();
        for (String s : tablica) {
            wynik.append(s).append(", ");
        }
        wynik.setLength(wynik.length() - 2);
        return wynik.toString();
    }
}
