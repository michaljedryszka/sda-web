package pl.sda.java.jsp.client;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class KalkulatorKlient {

    public static void main(String[] args) throws Exception{
        KalkulatorKlient klient = new KalkulatorKlient();
        String id = klient.utworzKalkulator();
        System.out.println(id);
        klient.wprowadz(id, "1");
        klient.dodaj(id);
        klient.wprowadz(id, "3");
        klient.wykonaj(id);
        System.out.println(klient.wyswietl(id));
    }

    private String wyswietl(String id) throws Exception{
        URL url = new URL("http://localhost:9999/web/rkalkulator/"+id+"/wyswietl");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int code = connection.getResponseCode();
        String wynik = null;
        if(code == HttpServletResponse.SC_OK){
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            wynik = in.readLine();
            in.close();
        }
        connection.disconnect();
        return wynik;
    }

    private void wykonaj(String id) throws Exception{
        URL url = new URL("http://localhost:9999/web/rkalkulator/"+id+"/wykonaj");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        connection.getResponseCode();
        connection.disconnect();
    }

    private void dodaj(String id) throws Exception{
        URL url = new URL("http://localhost:9999/web/rkalkulator/"+id+"/dodaj");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        connection.getResponseCode();
        connection.disconnect();
    }

    private void wprowadz(String id, String s) throws Exception {
        URL url = new URL("http://localhost:9999/web/rkalkulator/"+id+"/wprowadz/" + s);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        connection.getResponseCode();
        connection.disconnect();
    }

    private String utworzKalkulator() throws Exception {
        URL url = new URL("http://localhost:9999/web/rkalkulator");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        int code = connection.getResponseCode();
        String wynik = null;
        if(code == HttpServletResponse.SC_OK){
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            wynik = in.readLine();
            in.close();
        }
        connection.disconnect();
        return wynik;
    }
}
