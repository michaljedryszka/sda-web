package pl.sda.java.jsp.rest.domain;

import java.util.*;

public class ForumManager {

    private static Map<Integer, Forum> FORUMS = new HashMap();

    static {
        Forum initialForum = new Forum();
        initialForum.setName("Initial forum");
        initialForum.setUsers(Arrays.asList("admin, moderator"));
        Subject subject = new Subject();
        subject.setAuthor("admin");
        subject.setTitle("Forum rules");
        subject.setPublicationDate(new Date().getTime());
        subject.setContent("Rules of conduct: ....");
        initialForum.setSubjects(Arrays.asList(subject));
        FORUMS.put(1, initialForum);
    }

    public Forum getForum(int forumId) {
        return FORUMS.get(forumId);
    }

    public Collection<Forum> getForums() {
        return FORUMS.values();
    }

    public List<Subject> getSubjects(int forumId) {
        return FORUMS.get(forumId).getSubjects();
    }

    public Subject getSubject(int forumId, int subjectId) {
        return FORUMS.get(forumId).getSubjects().stream().filter(s -> s.getId() == subjectId).findFirst()
                .orElseGet(null);
    }

    public List<Answer> getAnswers(int forumId, int subjectId) {
        return getSubject(forumId, subjectId).getAnswers();
    }
}
