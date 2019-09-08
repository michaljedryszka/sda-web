package pl.sda.java.jsp.forum.view;

import pl.sda.java.jsp.forum.domain.Answer;
import pl.sda.java.jsp.forum.domain.Subject;

import java.util.Comparator;
import java.util.Date;
import java.util.TreeSet;

public class SubjectView extends Subject {

    public SubjectView(Subject subject){
        setAnswers(subject.getAnswers());
        setAuthor(subject.getAuthor());
        setContent(subject.getContent());
        setTitle(subject.getTitle());
        setId(subject.getId());
        setPublicationDate(subject.getPublicationDate());
    }

    public Date getConvertedDate(){
        return new Date(getPublicationDate());
    }

    public Date getLastAnswerDate(){
        Comparator<Answer> comparator = Comparator.comparingLong(Answer::getPublicationDate);
        TreeSet<Answer> set = new TreeSet<>(comparator);
        set.addAll(getAnswers());
        if(set.isEmpty()){
            return null;
        }
        return new Date(set.last().getPublicationDate());
    }
}
