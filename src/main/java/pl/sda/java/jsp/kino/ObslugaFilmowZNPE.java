package pl.sda.java.jsp.kino;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class ObslugaFilmowZNPE extends ObslugaFilmow{

    int idFilmuWFiltrze;

    @Override
    public Film film(int idFilmu){

        Supplier sup = new Supplier() {
            @Override
            public Object get() {
                test();
                return new NullPointerException();
            }

            public void test(){};
        };

        //((Supplier) sup).test();

        sup = NullPointerException::new;

        sup = () -> new NullPointerException();

        //NullPointerException npe = NullPointerException::new;

        Predicate<? super Film> filtr = new Predicate<Film>() {
            @Override
            public boolean test(Film film) {
                return film.getId() == idFilmu;
            }
        };

        filtr = film -> film.getId() == idFilmu;

        filtr = this::filtrWklasie;

        return FILMY
                .stream()
                .filter(filtr)
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }

    boolean filtrWklasie(Film film){
        return film.getId() == idFilmuWFiltrze;
    }
}
