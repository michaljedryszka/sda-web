package pl.sda.java.jsp.jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "jspServlet", urlPatterns = "/jspServlet")
public class JspServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //odczytac wartosci parametrow 'a' i 'b'
        String a = req.getParameter("a");
        String b = req.getParameter("b");
        //konkatenacja a i b
        String c = a + b;
        //przekazanie wyniku do strony jsp
        req.setAttribute("c", c);
        //w stronie jsp prezentacja wyniku
        req.setAttribute("atrybutZadania", "wartosczZadania");
        req.getSession().setAttribute("atrybutSesji", "wartosczSesji");
        getServletConfig().getServletContext().setAttribute("atrybutKontekstu", "wartosczKontekstu");
        req.getRequestDispatcher("jsp/hello.jsp").forward(req, resp);
    }
}
