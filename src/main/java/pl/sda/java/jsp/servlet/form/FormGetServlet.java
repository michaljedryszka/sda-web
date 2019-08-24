package pl.sda.java.jsp.servlet.form;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author michaljedryszka
 */

@WebServlet(
        name = "formget",
        urlPatterns = {"/formget"}
)
public class FormGetServlet extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        String page = "<html>";
        page += "<p>Przykladowy formularz GET wygenerowany z servletu</p>";
        page += "<form action='./formtarget' method='GET'>";
        page += "<input name='nazwa_pola' value='warsoc pola'/>";
        page += "<input type='submit' value='wyslij'/>";
        page += "</form>";
        page += "<a href='./formtarget?a=b&c=d'>odnosnik</a>";
        page += "</html>";
        resp.getWriter().write(page);
    }
}
