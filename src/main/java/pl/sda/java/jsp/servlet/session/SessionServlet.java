package pl.sda.java.jsp.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Przyklad otworzenia sesji.
 * Argument getSession decyduje czy nowa sesja zostanie otwara
 * @author michaljedryszka
 */
@WebServlet(
        name = "sessionstart",
        urlPatterns = {"/sessionstart"}
)
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        String page = "<html>";
        if (req.getSession(false) == null) {
            page += "<p>Sesja nie wystartowana. Brak atrybutu. Startuje</p>";
            req.getSession(true).setAttribute("sessionstart", "Session started");
        } else {
            page += "<p>Sesja wystartowana</p>";
        }
        page += "</html>";
        resp.getWriter().write(page);
    }
}
