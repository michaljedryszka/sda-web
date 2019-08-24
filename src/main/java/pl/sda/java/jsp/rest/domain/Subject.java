package pl.sda.java.jsp.rest.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Subject extends Identifable{
    private String author;
    private String title;
    private String content;
    private LocalDateTime publicationDate;
    private List<Answer> answers = new ArrayList<>();

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers.addAll(answers);
    }
}
