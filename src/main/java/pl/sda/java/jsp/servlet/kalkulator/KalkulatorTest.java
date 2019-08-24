package pl.sda.java.jsp.servlet.kalkulator;

//import static org.junit.Assert.*;

public class KalkulatorTest {

    private Kalkulator kalkulator;

//    @org.junit.Before
    public void setUp() throws Exception {
        System.out.println("setup");
        kalkulator = new Kalkulator();
    }

//    @org.junit.After
    public void tearDown() throws Exception {
    }

    ////@org.junit.Test
    public void przyjmijWartoscArgumentuIWyswietlWartosc() {
        String cyfra1 = "1";
        kalkulator.przyjmijWartoscArgumentu(cyfra1);
        String wartoscWyswietlona = kalkulator.wyswietlArgument();
        //assertEquals("1", wartoscWyswietlona);
    }

    //@org.junit.Test
    public void przyjmijWartoscArgumentowIWyswietlWartosc() {
        String cyfra1 = "1";
        kalkulator.przyjmijWartoscArgumentu(cyfra1);
        kalkulator.przyjmijWartoscArgumentu(cyfra1);
        String wartoscWyswietlona = kalkulator.wyswietlArgument();
        //assertEquals("11", wartoscWyswietlona);
    }

    //@org.junit.Test
    public void przyjmijWartoscArgumentu2() {
        String cyfra1 = "1";
        String cyfra2 = "2";
        kalkulator.przyjmijWartoscArgumentu(cyfra1);
        kalkulator.ustawOperator("+");
        kalkulator.przyjmijWartoscArgumentu(cyfra2);
        String wartoscWyswietlona = kalkulator.wyswietlArgument();
        //assertEquals("2", wartoscWyswietlona);
    }

    //@org.junit.Test
    public void obliczDodawanie() {
        String cyfra1 = "1";
        String cyfra2 = "2";
        kalkulator.przyjmijWartoscArgumentu(cyfra1);
        kalkulator.ustawOperator("+");
        kalkulator.przyjmijWartoscArgumentu(cyfra2);
        kalkulator.oblicz();
        //assertEquals("3", kalkulator.wyswietlArgument());
    }
}