package pl.sda.java.jsp.servlet.path;

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
        name = "analyzepath",
        urlPatterns = {"/analyzepath/*"}
)
public class AnalyzePathServlet extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        if(req.getPathInfo() != null){
            String pathInfo = req.getPathInfo();
            final String[] tablicaElementow = pathInfo.split("/");
        }
        resp.getWriter().write("Path info: " + req.getPathInfo());
    }
}
