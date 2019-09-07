package pl.sda.java.jsp.forum.servlet;


import pl.sda.java.jsp.forum.domain.Forum;
import pl.sda.java.jsp.forum.domain.ForumManager;
import pl.sda.java.jsp.forum.view.ForumView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

@WebServlet(
        name = "forumList",
        urlPatterns = "/forumList"
)
public class ForumListServlet extends HttpServlet {

    private ForumManager forumManager;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<Forum> forums = forumManager.getForums();
        req.setAttribute("forums",
                forums.stream()
                        .map(ForumView::new)
                        .collect(Collectors.toList()));
        req.getRequestDispatcher("forum/forumList.jsp").forward(req, resp);
    }

    @Override
    public void init() throws ServletException {
        this.forumManager = new ForumManager();
    }
}
