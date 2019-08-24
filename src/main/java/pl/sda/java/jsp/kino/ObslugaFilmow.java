package pl.sda.java.jsp.kino;

import java.time.LocalDate;
import java.util.*;

public class ObslugaFilmow implements IObslugaFilmow{

    protected static final List<Film> FILMY = Arrays.asList(
            new Film(1, "Szybcy i wsciekli", null, null, null),
                new Film(2, "Krol Lew", null, null, null),
                new Film(3, "Polityk", null, null, null)
        );

    public List<Film> listaFilmow(String miasto, LocalDate data){
        return FILMY;
    }

    public Film film(int idFilmu){
        return FILMY
                .stream()
                .filter(film -> film.getId() == idFilmu)
                .findFirst()
                .orElse(null);
    }

    public List<Kino> listaKin(int idFilmu){
        List<Kino> listaKin = new ArrayList<>();
        Film filmOId = film(idFilmu);
        List<Seans> listaSeansow = Arrays.asList(
                new Seans(filmOId, "10:00", null, null, null),
                new Seans(filmOId, "15:00", null, null, null)
        );
        Kino kino = new Kino("Warszawa", "Muranow", listaSeansow);
        listaKin.add(kino);
        return listaKin;
    }
}
