package pl.sda.java.jsp.servlet.kalkulator;

public abstract class Dzialanie {
    protected String argument1;
    protected String argument2;

    public abstract String policz();

    public String getArgument1() {
        return argument1;
    }

    public void setArgument1(String argument1) {
        this.argument1 = argument1;
    }

    public String getArgument2() {
        return argument2;
    }

    public void setArgument2(String argument2) {
        this.argument2 = argument2;
    }
}
