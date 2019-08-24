package pl.sda.java.jsp.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Wywolanie zadania GET
 */
public class URLGet {

    public static void main(String[] args) throws Exception {
        // Przekazanie parametrow przez url
        URL url = new URL("http://localhost:9999/web/kalkulator?arg=12");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // Ustawienie metody
        connection.setRequestMethod("GET");
        // Naglowki
        connection.setRequestProperty("Content-Type", "text/html");
        // Cookie
        connection.setRequestProperty("Cookie", "JSESSIONID=3t3923i78max4yspoc777dm1;");

        // Wykonanie -> getResponseCode | connect | getInputStream | getOutputStream
        int code = connection.getResponseCode();
        System.out.println(code);
        // Czytanie odpowiedzi
        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        System.out.println(content.toString());
        // Cookies
        String cookiesHeader = connection.getHeaderField("Set-Cookie");
        System.out.println(cookiesHeader);
        // Zakonczenie
        connection.disconnect();
    }
}
