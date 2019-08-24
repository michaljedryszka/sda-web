package pl.sda.java.jsp;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FiguraGeometryczna {

    double sumaPol(Collection<OperacjeGeometryczne> figury){
        double suma = 0;
/*
        for(OperacjeGeometryczne figura : figury){
            suma = suma + figura.obliczPole();
        }
*/
        suma = figury
                .stream()
                .map(i-> i.obliczPole())
                .collect(Collectors.summingDouble(Double::doubleValue));
        return suma;
    }

    public static void main(String[] args) {
        Kwadrat k = new Kwadrat(5);
        Prostokat p = new Prostokat(3,4);
        Trojkat t = new Trojkat(5, 6);
        List<OperacjeGeometryczne> listaFigur = Arrays.asList(k, p, t);
        FiguraGeometryczna fg = new FiguraGeometryczna();

        System.out.println(fg.sumaPol(listaFigur));
    }
}

class Kwadrat implements OperacjeGeometryczne{
    private int bok;

    public Kwadrat(int bok) {
        this.bok = bok;
    }

    @Override
    public double obliczPole() {
        return bok * bok;
    }
}

class Prostokat implements OperacjeGeometryczne{
    private int wysokosc;
    private int podstawa;

    public Prostokat(int wysokosc, int podstawa) {
        this.wysokosc = wysokosc;
        this.podstawa = podstawa;
    }

    @Override
    public double obliczPole() {
        return wysokosc * podstawa;
    }
}

class Trojkat implements OperacjeGeometryczne{
    private int wysokosc;
    private int podstawa;

    public Trojkat(int wysokosc, int podstawa) {
        this.wysokosc = wysokosc;
        this.podstawa = podstawa;
    }

    @Override
    public double obliczPole() {
        int i = 123;
        long j = 12345678901234567l;
        double f = 0.5;
        return 0.5 * wysokosc * podstawa;
    }
}

class Trapez implements OperacjeGeometryczne{
    int podstawaDolna;
    int podstawaGorna;
    int wysokosc;

    @Override
    public double obliczPole() {
        return wysokosc * (podstawaDolna + podstawaGorna)/2;
    }
}

class Kolo implements OperacjeGeometryczne{
    int promien;

    @Override
    public double obliczPole() {
        return Math.PI * promien * promien;
    }
}

interface OperacjeGeometryczne {
    int a = 1;
    int b = 2;
    int r = 3;

    double obliczPole();
}