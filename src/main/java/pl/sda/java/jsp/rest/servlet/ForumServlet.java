package pl.sda.java.jsp.rest.servlet;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.sda.java.jsp.rest.domain.ForumManager;

@WebServlet(
        name = "forum",
        urlPatterns = {"/forum", "/forum/*"}
)
public class ForumServlet extends HttpServlet {

    private ForumManager forumManager;

    private Gson gson;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print(gson.toJson(forumManager.getForums()));
        resp.setContentType("application/json");
    }

    @Override
    public void init() throws ServletException {
        forumManager = new ForumManager();
        gson = new Gson();
    }
}
