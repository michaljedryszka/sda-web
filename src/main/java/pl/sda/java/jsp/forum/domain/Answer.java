package pl.sda.java.jsp.forum.domain;

import java.util.Objects;

public class Answer extends Identifable{
    private String author;
    private long publicationDate;
    private String content;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(long publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return publicationDate == answer.publicationDate &&
                Objects.equals(author, answer.author) &&
                Objects.equals(id, answer.id) &&
                Objects.equals(content, answer.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, publicationDate, content, id);
    }
}
