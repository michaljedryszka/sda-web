package pl.sda.java.jsp.servlet.kalkulator;

public class Kalkulator {

    private String arg1 = "";
    private String arg2 = "";
    private String operator;

    void ustawOperator(String wartoscOperatora){
        operator = wartoscOperatora;
    }

    void przyjmijWartoscArgumentu(String wartosc){
        if(operator == null){
            arg1 += wartosc;
        } else {
            arg2 += wartosc;
        }
    }

    String wyswietlArgument(){
        if(operator == null) {
            return arg1;
        } else{
            return arg2;
        }
    }

    public String getWyswietlArgument(){
        return wyswietlArgument();
    }

    void oblicz() {
        switch (operator) {
            case "+":
                this.operator = null;
                arg1 = String.valueOf(
                        Integer.valueOf(arg1) + Integer.valueOf(arg2));
                break;
            case "-":
                this.operator = null;
                arg1 = String.valueOf(
                        Integer.valueOf(arg1) - Integer.valueOf(arg2));
                break;
            default:
                this.operator = null;
                throw new UnsupportedOperationException(operator);
        }
        arg2 = "";
    }

    public void resetuj() {
        operator = null;
        arg2 = "";
        arg1 = "";
    }
}
