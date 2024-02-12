package org.example.lab21;

import java.io.*;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "SakunServlet", value = "/Sakun")
public class SakunServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Отримання реального шляху до ресурсів вашого веб-додатка
        ServletContext context = getServletContext();
        String path = context.getRealPath("/Sakun.html");

        // Читання HTML-файлу
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while ((line = br.readLine()) != null) {
            out.println(line);
        }
        br.close();
    }

    public void destroy() {
    }
}