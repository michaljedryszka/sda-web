package pl.sda.java.jsp.forum.servlet;

import pl.sda.java.jsp.forum.domain.Answer;
import pl.sda.java.jsp.forum.domain.ForumManager;
import pl.sda.java.jsp.forum.domain.Subject;
import pl.sda.java.jsp.forum.view.SubjectView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(
        name = "subjectList",
        urlPatterns = "/subjectList"
)
public class SubjectListServlet extends HttpServlet {

    private ForumManager forumManager;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Subject> subjects = forumManager.getSubjects(Integer.valueOf(req.getParameter("forumId")));
        //Sortowanie po dacie ostatniej odpowiedzi
        String sortDirection = req.getParameter("sort");
        if ("asc".equals(sortDirection)) {

        } else if ("desc".equals(sortDirection)) {

        } else {
            Collections.sort(subjects, Comparator.comparingLong(Subject::getPublicationDate));
        }
        req.setAttribute("subjects", subjects
                .stream()
                .map(SubjectView::new)
                .collect(Collectors.toList())
        );
        req.getRequestDispatcher("forum/subjectList.jsp").forward(req, resp);
    }

    @Override
    public void init() throws ServletException {
        forumManager = new ForumManager();
    }
}
