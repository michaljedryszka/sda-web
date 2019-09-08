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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@WebServlet(
        name = "subjectList",
        urlPatterns = "/subjectList"
)
public class SubjectListServlet extends HttpServlet {

    private ForumManager forumManager;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int forumId = Integer.valueOf(req.getParameter("forumId"));

        if(req.getParameter("subjectToDelete") != null){
            int subjectToDelete = Integer.valueOf(req.getParameter("subjectToDelete"));
            forumManager.deleteSubject(forumId, subjectToDelete);
        }
        if(req.getParameter("subjectToEdit") != null){
            int subjectToEdit = Integer.valueOf(req.getParameter("subjectToEdit"));
            Subject subject = forumManager.getSubject(forumId, subjectToEdit);
            req.setAttribute("subjectToEdit", subject);
        }

        List<Subject> subjects = forumManager.getSubjects(forumId);
        Function<Subject, SubjectView> mapperByInstance = new Mapper();
        Function<Subject, SubjectView> mapperAnonymousInstance = new Function<Subject, SubjectView>() {           @Override
            public SubjectView apply(Subject subject) {
                return new SubjectView(subject);
            }
        };
        Function<Subject, SubjectView> mapperByMethod = this::mapper;
        Function<Subject, SubjectView> mapperByLambda = (x) -> new SubjectView(x);
        Function<Subject, SubjectView> mapperByConstructor = SubjectView::new;
        List<SubjectView> subjectViews = subjects
                .stream()
//                .map(mapperByInstance)
//                .map(mapperAnonymousInstance)
//                .map(mapperByMethod)
//                .map(mapperByLambda)
//                .map(mapperByConstructor)
                .map(SubjectView::new)
                .collect(Collectors.toList());
        //Sortowanie po dacie ostatniej odpowiedzi
        String sortDirection = req.getParameter("sort");
        if ("asc".equals(sortDirection)) {
            Collections.sort(subjectViews, Comparator.comparing(SubjectView::getLastAnswerDate));
        } else if ("desc".equals(sortDirection)) {
            Collections.sort(subjectViews, Comparator.comparing(SubjectView::getLastAnswerDate).reversed());
        } else {
            Collections.sort(subjectViews, Comparator.comparingLong(Subject::getPublicationDate));
        }
        req.setAttribute("subjects", subjectViews);
        req.getRequestDispatcher("forum/subjectList.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int forumId = Integer.valueOf(req.getParameter("forumId"));
        String author = req.getParameter("author");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        if(req.getParameter("subjectToEdit") == null){
            forumManager.addSubject(forumId, author, title, content);
        }else{
            int subjectId = Integer.valueOf(req.getParameter("subjectToEdit"));
            forumManager.updateSubject(forumId, subjectId, title, content);
        }
        resp.sendRedirect("/web/subjectList?forumId=" + forumId);
    }

    @Override
    public void init() throws ServletException {
        forumManager = new ForumManager();
    }

    SubjectView mapper(Subject subject){
        return new SubjectView(subject);
    }

    public static void main(String[] args) {
        List<Object> listo = new ArrayList<>();
        int x = 1;
        listo.add(x);
        String s = "s";
        listo.add(s);

        int xo = Integer.class.cast(listo.get(0));
        xo = (int)listo.get(0);
        List<Subject> subjects = null;
        List<SubjectView> subjectViews = null;
        //subjectViews = subjects;
        subjects = (List)subjectViews;
        List list = new ArrayList();
        int y=1;
        list.add(y);
        y = (int )list.get(0);
    }
}

class Mapper implements Function<Subject, SubjectView>{
    @Override
    public SubjectView apply(Subject subject) {
        return new SubjectView(subject);
    }
}