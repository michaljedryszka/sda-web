package pl.sda.java.jsp.servlet.kalkulator;

import java.util.function.BiFunction;

public class Kalkulator {

    private String argument1 = "";
    private String argument2 = "";
    private String operator;

    public void wprowadz(String wartosc){
        argument1 += wartosc;
    }

    public String wyswietl(){
        return argument1;
    }

    public void wyczysc(){
        argument1 = "";
    }

    public void dodaj(){
        argument2 = argument1;
        argument1 = "";
        operator = "+";
    }

    public void odejmij(){
        argument2 = argument1;
        argument1 = "";
        operator = "-";
    }

    public void wykonaj(Dzialanie dzialanie) {
        dzialanie.setArgument1(argument1);
        dzialanie.setArgument2(argument2);
        argument1 = dzialanie.policz();
    }

    public String wykonaj(BiFunction<String, String, String> biFunction, String argument1, String argument2) {
        return biFunction.apply(argument1, argument2);
    }

    public void wykonaj(){
        Dzialanie dzialanie = null;
        if("+".equals(operator)){
            dzialanie = new Dodawanie();
        }
        if("-".equals(operator)){
            dzialanie = new Odejmowanie();
        }
        dzialanie.setArgument1(argument1);
        dzialanie.setArgument2(argument2);
        argument1 = dzialanie.policz();
    }

    public void wykonaj2(){
        if("+".equals(operator)){
            argument1 = (Integer.valueOf(argument1)
                    + Integer.valueOf(argument2))+"";
        }
        if("-".equals(operator)){
            argument1 = (Integer.valueOf(argument2)
                    - Integer.valueOf(argument1))+"";
        }
    }
}
