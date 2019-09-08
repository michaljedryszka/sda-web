package pl.sda.java.jsp.forum.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Forum extends Identifable{
    private String name;
    private List<Subject> subjects = new ArrayList<>();
    //private List<String> users = new ArrayList<>();

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
        Set<String> users = new HashSet<>();
        for(Subject subject: subjects){
            users.add(subject.getAuthor());
            for(Answer answer : subject.getAnswers()){
                users.add(answer.getAuthor());
            }
        }
        users.addAll(subjects
                .stream()
                .map(Subject::getAuthor)
                .collect(Collectors.toSet()));
        users.addAll(subjects
                .stream()
                .map(Subject::getAnswers)
                .flatMap(Collection::stream)
                .map(Answer::getAuthor)
                .collect(Collectors.toSet()));
        return new ArrayList<>(users);
    }

/*
    public void setUsers(List<String> users) {
        this.users = users;
    }
*/
}
