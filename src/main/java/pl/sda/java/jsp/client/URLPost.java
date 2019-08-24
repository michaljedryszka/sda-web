package pl.sda.java.jsp.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Wywołanie zadania post
 */
public class URLPost {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:9999/web/kalkulator");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // Ustawienie metody
        connection.setRequestMethod("POST");
        // Naglowki
        connection.setRequestProperty("Content-Type", "text/html");
        // Cookie
        connection.setRequestProperty("Cookie", "JSESSIONID=3t3923i78max4yspoc777dm1;");
        // Przekazanie parametrow przez url
        connection.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        out.writeBytes("ce=true");
        out.flush();
        out.close();

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
