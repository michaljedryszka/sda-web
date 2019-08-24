package pl.sda.java.jsp.rest.domain;

import java.util.ArrayList;
import java.util.List;

public class Forum extends Identifable{
    private String name;
    private List<Subject> subjects = new ArrayList<>();
    private List<String> users = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects.addAll(subjects);
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }
}
