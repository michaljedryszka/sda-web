package pl.sda.java.jsp.servlet.kalkulator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KalkulatorTest {

    Kalkulator kalkulator;

    @Before
    public void setUp() throws Exception {
        kalkulator = new Kalkulator();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testWprowadzaniaDanych() {
        // Given
        kalkulator.wprowadz("5");
        // When
        String actual = kalkulator.wyswietl();
        // Then
        assertEquals("5", actual);
    }

    @Test
    public void testWyczysc() {
        // Given
        kalkulator.wprowadz("5");
        kalkulator.wprowadz("1");
        kalkulator.wyczysc();
        // When
        String actual = kalkulator.wyswietl();
        // Then
        assertEquals("", actual);
    }

    @Test
    public void testDodaj() {
        // Given
        kalkulator.wprowadz("5");
        kalkulator.wprowadz("1");
        kalkulator.dodaj();
        kalkulator.wprowadz("2");
        kalkulator.wykonaj();

        // When
        String actual = kalkulator.wyswietl();
        // Then
        assertEquals("53", actual);
    }

    @Test
    public void testOdejmij() {
        // Given
        kalkulator.wprowadz("5");
        kalkulator.wprowadz("1");
        kalkulator.odejmij();
        kalkulator.wprowadz("2");
        kalkulator.wykonaj();

        // When
        String actual = kalkulator.wyswietl();
        // Then
        assertEquals("49", actual);
    }

    @Test
    public void testBifunction() {
        // Given
        String argx = "1";
        String argy = "2";

        // When
        String actual = kalkulator.wykonaj(this::zzzzz,
                argx, argy);

        // Then
        assertEquals("12", actual);
    }

    @Test
    public void testBifunctionDivide() {
        // Given
        String argx = "8";
        String argy = "2";
        // When
        String actual = kalkulator.wykonaj((x, y) -> (Integer.valueOf(x)/
                        Integer.valueOf(y)) + "",
                argx, argy);
        // Then
        assertEquals("4", actual);
    }

    public String zzzzz(String a, String b){
        return a + b;
    }
}