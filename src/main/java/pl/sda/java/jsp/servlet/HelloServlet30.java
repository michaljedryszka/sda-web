package pl.sda.java.jsp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author michaljedryszka
 */
@WebServlet(
        name = "helloServlet30",
        urlPatterns = {"/sayhello30"},
        initParams = {@WebInitParam(name = "n1", value = "v1"), @WebInitParam(name = "n2", value = "v2")}
)
public class HelloServlet30 extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("Hello World 3.0");
        final Enumeration<String> initParameterNames = this.getInitParameterNames();
        while(initParameterNames.hasMoreElements()){
            out.print(getInitParameter(initParameterNames.nextElement()));
        }
    }
}
