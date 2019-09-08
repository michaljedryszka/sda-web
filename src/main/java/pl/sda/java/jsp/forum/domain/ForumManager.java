package pl.sda.java.jsp.forum.domain;

import java.util.*;

public class ForumManager {

    private static Map<Integer, Forum> FORUMS = new HashMap();

    static {
        for(int i = 0; i < 10 ; i++){
            Forum initialForum = new Forum();
            initialForum.setName("Forum " + i);
            //initialForum.setUsers(Arrays.asList("admin", "moderator"));
            for(int j = 0; j < 20; j ++){
                Subject subject = new Subject();
                subject.setAuthor("admin");
                subject.setTitle("Subject " + i + " " + j);
                subject.setPublicationDate(new Date().getTime());
                subject.setContent("Content : ...." + i + " " + j);
                initialForum.setSubjects(Arrays.asList(subject));
                for(int k = 0; k < 15; k ++){
                    Answer answer = new Answer();
                    answer.setAuthor("autor " + k);
                    answer.setContent("Response " + k);
                    answer.setPublicationDate(new Date().getTime());
                    subject.getAnswers().add(answer);
                }
            }
            FORUMS.put(initialForum.getId(), initialForum);
        }
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

    public void addAnswer(int forumId, int subjectId, String author, String content) {
        Subject subject = getSubject(forumId, subjectId);
        Answer answer = new Answer();
        answer.setAuthor(author);
        answer.setContent(content);
        answer.setPublicationDate(new Date().getTime());
        subject.getAnswers().add(answer);
    }

    public void addSubject(int forumId, String author, String title, String content) {
        Subject subject = new Subject();
        subject.setAuthor(author);
        subject.setContent(content);
        subject.setTitle(title);
        subject.setPublicationDate(new Date().getTime());
        getForum(forumId).getSubjects().add(subject);
    }

    public void deleteSubject(int forumId, int subjectToDelete) {
        Forum forum = getForum(forumId);
        Subject subject = getSubject(forumId, subjectToDelete);
        forum.getSubjects().remove(subject);
    }

    public void updateSubject(int forumId, int subjectId, String title, String content) {
        Subject subject = getSubject(forumId, subjectId);
        subject.setTitle(title);
        subject.setContent(content);
    }
}
