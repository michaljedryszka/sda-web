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
        name = "formself",
        urlPatterns = {"/formself"}
)
public class FormSelfServlet extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        String page = "<html>";
        page += "<p>Przykladowy formularz GET submitujacy do siebie</p>";
        page += "<form action='' method='GET'>";
        page += "<input name='nazwa_pola' value='warsoc pola'/>";
        page += "<input type='submit' value='wyslij'/>";
        page += "</form>";

        final Enumeration<String> parameternames = req.getParameterNames();
        while (parameternames.hasMoreElements()) {
            final String parameterName = parameternames.nextElement();
            page += "<p> parametr: " + parameterName + "; wartosc: " + req.getParameterValues(parameterName)[0] + "</p>";
        }
        page += "</html>";
        resp.getWriter().write(page);
    }
}
