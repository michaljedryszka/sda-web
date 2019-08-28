package pl.sda.java.jsp.servlet.kalkulator;

public class Dodawanie extends Dzialanie {
    @Override
    public String policz() {
        return (Integer.valueOf(argument1) + Integer.valueOf(argument2)) + "";
    }
}
