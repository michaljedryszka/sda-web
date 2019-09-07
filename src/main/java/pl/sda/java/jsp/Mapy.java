package pl.sda.java.jsp;

import java.util.HashMap;
import java.util.Map;

public class Mapy {
    public static void main(String[] args) {
        Map<Klucz, Object> mapa = new HashMap<>();
        Klucz k = new Klucz(10);
        mapa.put(k, 10);
        //k.i = 4;
        System.out.println(mapa.get(k));
    }
}

class Klucz{
    private int i;

    public Klucz(int i) {
        this.i = i;
    }

    @Override
    public int hashCode() {
        return i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klucz klucz = (Klucz) o;
        return i == klucz.i;
    }
}