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
        String pathInfo = req.getPathInfo();
        int status = HttpServletResponse.SC_NOT_FOUND;
        if (pathInfo == null) {
            resp.getWriter().print(gson.toJson(forumManager.getForums()));
            status = HttpServletResponse.SC_FOUND;
        } else if (!pathInfo.contains("/subject") && !pathInfo.contains("/answer")) {
            String[] splitted = pathInfo.split("/");
            int forumId = Integer.valueOf(splitted[1]);
            resp.getWriter().print(gson.toJson(forumManager.getForum(forumId)));
            status = HttpServletResponse.SC_FOUND;
        } else if (pathInfo.contains("/subject") && !pathInfo.contains("/answer")) {
            String[] splitted = pathInfo.split("/");
            int forumId = Integer.valueOf(splitted[1]);
            if (forumManager.getForum(forumId) != null) {
                resp.getWriter().print(gson.toJson(forumManager.getForum(forumId).getSubjects()));
                status = HttpServletResponse.SC_FOUND;
            }
        }
        resp.setContentType("application/json");
        resp.setStatus(status);
    }

    @Override
    public void init() throws ServletException {
        forumManager = new ForumManager();
        gson = new Gson();
    }
}
