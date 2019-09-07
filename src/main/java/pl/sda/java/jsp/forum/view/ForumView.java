package pl.sda.java.jsp.forum.view;

import pl.sda.java.jsp.forum.domain.Forum;

public class ForumView extends Forum {

    public ForumView(Forum forum){
        setName(forum.getName());
        setSubjects(forum.getSubjects());
        setUsers(forum.getUsers());
        setId(forum.getId());
    }

    public int getSubjectCount(){
        return getSubjects().size();
    }

    public int getUserCount(){
        return getUsers().size();
    }

    public String getLastSubject(){
        return getSubjects().get(0).getTitle();
    }
}
