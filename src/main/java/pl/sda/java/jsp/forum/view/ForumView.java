package pl.sda.java.jsp.forum.view;

import pl.sda.java.jsp.forum.domain.Answer;
import pl.sda.java.jsp.forum.domain.Forum;
import pl.sda.java.jsp.forum.domain.Subject;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ForumView extends Forum {

    public ForumView(Forum forum){
        setName(forum.getName());
        setSubjects(forum.getSubjects());
        //setUsers(forum.getUsers());
        setId(forum.getId());
    }

    public int getSubjectCount(){
        return getSubjects().size();
    }

    public int getUserCount(){
        return getUsers().size();
    }

    public String getLastSubject(){
        //Znalezc subject w ktorym dodano ostatnia odpowiedz
        TreeSet<Answer> set =
                new TreeSet<>(Comparator.comparingLong(Answer::getPublicationDate));
/*
        for(Subject subject : getSubjects()) {
            set.addAll(subject.getAnswers());
        }
*/
        set.addAll(getSubjects()
                .stream()
                .map(Subject::getAnswers)
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));
/*
        getSubjects()
                .stream()
                .forEach(s -> set.addAll(s.getAnswers()));
*/
        if(set.isEmpty()){
            return null;
        }
        Answer answer = set.last();
        //set.last();
        for(Subject subject : getSubjects()){
            if(subject.getAnswers().contains(answer)){
                return subject.getTitle();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeSet<Integer> s = new TreeSet<>();
        s.add(50);
        s.add(1);
        s.add(100);
        System.out.println(s.last());

    }
}
