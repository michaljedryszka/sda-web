package pl.sda.java.jsp.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

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
        connection.setRequestProperty("Cookie", "JSESSIONID=mghc8vs8ei8qqqj3bg6jrdf1;");
        // Przekazanie parametrow przez url

        String urlParameters = "evaluate=%3D";
        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
        int postDataLength = postData.length;

        connection.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
        connection.setRequestProperty( "charset", "utf-8");
        connection.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));

        connection.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        out.write(postData);
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
