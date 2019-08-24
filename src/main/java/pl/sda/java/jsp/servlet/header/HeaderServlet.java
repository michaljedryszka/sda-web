package pl.sda.java.jsp.servlet.header;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;


/**
 * Odczyt i zapis naglowkow w zadaniu i odpowiedzi
 */
@WebServlet(
        name = "headers",
        urlPatterns = "/headers"
)
public class HeaderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write("<p>Naglowki zadania:</p>");
        Enumeration<String> requestHeaderNames = req.getHeaderNames();
        while (requestHeaderNames.hasMoreElements()) {
            String headerName = requestHeaderNames.nextElement();
            resp.getWriter().write(String.format("<p>%s: %s</p>", headerName, req.getHeader(headerName)));
        }
        resp.getWriter().write("<p>Naglowki odpowiedzi:</p>");
        Collection<String> respHeaderNames = resp.getHeaderNames();
        resp.setHeader("test-header", "naglowek testowy");
        for (String headerName : respHeaderNames) {
            resp.getWriter().write(String.format("<p>%s: %s</p>", headerName, resp.getHeader(headerName)));
        }
    }
}
