package pl.sda.java.jsp.forum.view;

import pl.sda.java.jsp.forum.domain.Answer;

import java.util.Date;

public class AnswerView extends Answer {
    public AnswerView(Answer answer) {
        setAuthor(answer.getAuthor());
        setContent(answer.getContent());
        setPublicationDate(answer.getPublicationDate());
    }

    public Date getConvertedDate(){
        return new Date(getPublicationDate());
    }
}
