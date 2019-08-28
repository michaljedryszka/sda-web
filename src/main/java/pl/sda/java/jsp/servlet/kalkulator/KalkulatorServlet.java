package pl.sda.java.jsp.servlet.kalkulator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author michaljedryszka
 */
@WebServlet(
        name = "servlet",
        urlPatterns = "/kalkulator"
)
public class KalkulatorServlet extends HttpServlet {

    private Kalkulator kalkulator = new Kalkulator();

    @Override
    public void doGet(final HttpServletRequest req,
                      final HttpServletResponse resp) throws IOException, ServletException {
        String arg = req.getParameter("arg");
        if(arg == null){
            arg = "";
        }
        kalkulator.wprowadz(arg);
        printCalculator(resp);
    }

    @Override
    public void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws IOException, ServletException {
        if(req.getParameter("ce") != null){
            kalkulator.wyczysc();
        }
        if("+".equals(req.getParameter("operator"))){
            kalkulator.dodaj();
        }
        if("-".equals(req.getParameter("operator"))){
            kalkulator.odejmij();
        }
        if(req.getParameter("evaluate") != null){
            kalkulator.wykonaj();
        }
        printCalculator(resp);
    }

    private void printCalculator(HttpServletResponse resp) throws IOException {
        resp.getWriter().print("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<table>\n" +
                "    <tr>\n" +
                "        <td colspan=\"3\"><input type=\"text\" readonly value=\"" + kalkulator.wyswietl() + "\"/></td>\n" +
                "        <td>\n" +
                "            <form action=\"/web/kalkulator\" method=\"POST\">\n" +
                "                <input type=\"submit\" name=\"ce\" value=\"CE\"/></form>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <form action=\"/web/kalkulator\" method=\"GET\">\n" +
                "            <td><input type=\"submit\" name=\"arg\" value=\"7\"/></td>\n" +
                "            <td><input type=\"submit\" name=\"arg\" value=\"8\"/></td>\n" +
                "            <td><input type=\"submit\" name=\"arg\" value=\"9\"/></td>\n" +
                "        </form>\n" +
                "        <form action=\"/web/kalkulator\" method=\"POST\">\n" +
                "            <td><input type=\"submit\" name=\"operator\" value=\"+\"/></td>\n" +
                "        </form>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <form action=\"/web/kalkulator\" method=\"GET\">\n" +
                "            <td><input type=\"submit\" name=\"arg\" value=\"4\"/></td>\n" +
                "            <td><input type=\"submit\" name=\"arg\" value=\"5\"/></td>\n" +
                "            <td><input type=\"submit\" name=\"arg\" value=\"6\"/></td>\n" +
                "        </form>\n" +
                "        <form action=\"/web/kalkulator\" method=\"POST\">\n" +
                "            <td><input type=\"submit\" name=\"operator\" value=\"-\"/></td>\n" +
                "        </form>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <form action=\"/web/kalkulator\" method=\"GET\">\n" +
                "            <td><input type=\"submit\" name=\"arg\" value=\"1\"/></td>\n" +
                "            <td><input type=\"submit\" name=\"arg\" value=\"2\"/></td>\n" +
                "            <td><input type=\"submit\" name=\"arg\" value=\"3\"/></td>\n" +
                "        </form>\n" +
                "        <form action=\"/web/kalkulator\" method=\"POST\">\n" +
                "            <td><input type=\"submit\" name=\"evaluate\" value=\"=\"/></td>\n" +
                "        </form>\n" +
                "    </tr>\n" +
                "    <form action=\"/web/kalkulator\" method=\"GET\">\n" +
                "        <tr>\n" +
                "            <td><input type=\"submit\" name=\"arg\" value=\"0\"/></td>\n" +
                "            <td/>\n" +
                "            <td/>\n" +
                "            <td/>\n" +
                "        </tr>\n" +
                "    </form>\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>");
    }
}
