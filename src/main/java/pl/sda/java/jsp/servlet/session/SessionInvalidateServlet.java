package pl.sda.java.jsp.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Przyklad odczytu wartosci atrybutu sesji.
 * Zamkniecie sesji
 *
 * @author michaljedryszka
 */
@WebServlet(
        name = "sessionstop",
        urlPatterns = {"/sessionstop"}
)
public class SessionInvalidateServlet extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        String page = "<html>";
        if (req.getSession(false) != null) {
            page += "<p>Sesja ustawiona, wartosc:" + req.getSession().getAttribute("sessionstart") + "</p>";
            page += "<p>Invaliduje</p>";
            req.getSession().invalidate();
        } else {
            page += "<p>Sesja nie ustawiona</p>";
        }
        page += "</html>";
        resp.getWriter().write(page);
    }
}
