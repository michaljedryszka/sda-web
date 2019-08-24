package pl.sda.java.jsp.kino;

import java.time.LocalDate;
import java.util.List;

public interface IObslugaFilmow {
    List<Film> listaFilmow(String miasto, LocalDate data);
    Film film(int idFilmu);
    List<Kino> listaKin(int idFilmu);
}
