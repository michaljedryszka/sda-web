package pl.sda.java.jsp.servlet.file;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@WebServlet(name = "fileupload", urlPatterns = "/fileupload")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("<html lang=\"en\">\n" +
                "    <head>\n" +
                "        <title>File Upload</title>\n" +
                "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <form method=\"POST\" action=\"fileupload\" enctype=\"multipart/form-data\" >\n" +
                "            Plik:\n" +
                "            <input type=\"file\" name=\"file\" id=\"file\" /> <br/>\n" +
                "            <input type=\"submit\" value=\"Wyslij\" name=\"upload\" id=\"upload\" />\n" +
                "        </form>\n" +
                "    </body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Part filePart = req.getPart("file");
        final String fileName = getFileName(filePart);
        final File przeslanyPlik = new File(fileName);
        System.out.println(przeslanyPlik.getAbsolutePath());
        final FileOutputStream out = new FileOutputStream(przeslanyPlik);
        final InputStream filecontent = filePart.getInputStream();
        int read = 0;
        final byte[] bytes = new byte[4096];

        while ((read = filecontent.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
        out.close();
        doGet(req, resp);
    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
