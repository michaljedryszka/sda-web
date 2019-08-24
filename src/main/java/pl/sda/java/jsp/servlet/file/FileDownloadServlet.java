package pl.sda.java.jsp.servlet.file;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Obsługa pobierania pliku
 */
@WebServlet(name = "filesownload", urlPatterns = "/filedownload")
public class FileDownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //typy: application/pdf, text/plain, text/html, image/jpg
        resp.setContentType("text/plain");
        resp.setHeader("Content-disposition", "attachment; filename=setup.log");
        File plik = new File("setup.log");
        OutputStream out = resp.getOutputStream();
        FileInputStream in = new FileInputStream(plik);
        byte[] buffer = new byte[4096];
        int length;
        while ((length = in.read(buffer)) > 0) {
            out.write(buffer, 0, length);
        }
        in.close();
        out.flush();
    }
}
