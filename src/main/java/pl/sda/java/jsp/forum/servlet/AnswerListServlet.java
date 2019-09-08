package pl.sda.java.jsp.forum.servlet;

import pl.sda.java.jsp.forum.domain.Answer;
import pl.sda.java.jsp.forum.domain.ForumManager;
import pl.sda.java.jsp.forum.view.AnswerView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(
        name = "answerServlet",
        urlPatterns = "/answerList"
)
public class AnswerListServlet extends HttpServlet {

    private ForumManager forumManager;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int forumId = Integer.valueOf(req.getParameter("forumId"));
        int subjectId = Integer.valueOf(req.getParameter("subjectId"));
        List<Answer> answers = forumManager.getAnswers(forumId, subjectId);
        req.setAttribute("answers", answers
            .stream()
            .map(AnswerView::new)
            .collect(Collectors.toList()));
        req.getRequestDispatcher("forum/answerList.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int forumId = Integer.valueOf(req.getParameter("forumId"));
        int subjectId = Integer.valueOf(req.getParameter("subjectId"));
        String author = req.getParameter("author");
        String content = req.getParameter("content");
        forumManager.addAnswer(forumId, subjectId, author, content);
    }

    @Override
    public void init() throws ServletException {
        forumManager = new ForumManager();
    }
}
