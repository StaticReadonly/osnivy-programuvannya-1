package org.example.lab21;

import java.io.*;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Sameliuk", value = "/sameliuk")
public class SameliukServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        ServletContext context = getServletContext();
        String path = context.getRealPath("/sameliuk_page.html");

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
