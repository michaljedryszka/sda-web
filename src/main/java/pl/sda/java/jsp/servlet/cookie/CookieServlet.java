package pl.sda.java.jsp.servlet.cookie;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Ilustracja odczytu i zapisu informacji z uzyciem ciasteczek
 * Zwroc uwage jak maxAge wplywa na czas zycia ciasteczka
 */
@WebServlet(
        name = "cookies",
        urlPatterns = "/cookies"
)
public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write("<p>Ciasteczka:</p>");
        for (Cookie cookie : req.getCookies()) {
            resp.getWriter().write("<p>" + cookie.getName() + " " + cookie.getValue() + "</p>");
        }
        Cookie cookie = new Cookie("age-1", "age:-1");
        cookie.setMaxAge(-1);
        resp.addCookie(cookie);
        cookie = new Cookie("age-0", "age:0");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
        cookie = new Cookie("age-5", "age:5");
        cookie.setMaxAge(5);
        resp.addCookie(cookie);
    }
}
