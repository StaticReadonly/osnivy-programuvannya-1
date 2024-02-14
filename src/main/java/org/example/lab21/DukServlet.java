package org.example.lab21;


import java.io.*;
import java.util.Date;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Duk", value = "/duk")
public class DukServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Duk Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello from Maksim!!!</h1>");
        out.println("<h1>Current Time: " + new Date() + "<h1>");
        out.println("</body>");
        out.println("</html>");

        ServletContext context = getServletContext();
        String path = context.getRealPath("/duk.html");

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
