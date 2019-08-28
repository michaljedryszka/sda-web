package pl.sda.java.jsp.servlet.kalkulator;

public class Odejmowanie extends Dzialanie{
    @Override
    public String policz() {
        return (Integer.valueOf(argument2) - Integer.valueOf(argument1)) + "";
    }
}
