package pl.sda.java.jsp.kino;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Seans {
    private Film film;
    private String godzina;
    private Sala sala;
    private BigDecimal cena;
    private LocalDate data;

    public Seans(Film film, String godzina, Sala sala, BigDecimal cena, LocalDate data) {
        this.film = film;
        this.godzina = godzina;
        this.sala = sala;
        this.cena = cena;
        this.data = data;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public String getGodzina() {
        return godzina;
    }

    public void setGodzina(String godzina) {
        this.godzina = godzina;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
