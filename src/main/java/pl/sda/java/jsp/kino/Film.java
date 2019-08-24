package pl.sda.java.jsp.kino;

public class Film {
    private int id;
    private String tytul;
    private String opis;
    private String rezyser;
    private String ocena;

    public Film(int id, String tytul, String opis, String rezyser, String ocena) {
        this.id = id;
        this.tytul = tytul;
        this.opis = opis;
        this.rezyser = rezyser;
        this.ocena = ocena;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getRezyser() {
        return rezyser;
    }

    public void setRezyser(String rezyser) {
        this.rezyser = rezyser;
    }

    public String getOcena() {
        return ocena;
    }

    public void setOcena(String ocena) {
        this.ocena = ocena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
