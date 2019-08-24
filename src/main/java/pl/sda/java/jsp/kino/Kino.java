package pl.sda.java.jsp.kino;

import java.util.List;

public class Kino {
    private String miasto;
    private String nazwa;
    private List<Seans> seanse;

    public Kino(String miasto, String nazwa, List<Seans> seanse) {
        this.miasto = miasto;
        this.nazwa = nazwa;
        this.seanse = seanse;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public List<Seans> getSeanse() {
        return seanse;
    }

    public void setSeanse(List<Seans> seanse) {
        this.seanse = seanse;
    }
}
