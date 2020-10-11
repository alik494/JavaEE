import logic.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/library")
public class FirstServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter=response.getWriter();
        printWriter.println("start");
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        try {
            Connection conn= DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "49410alik"
            );
            Statement stmt= conn.createStatement();
            ResultSet rs=stmt.executeQuery("select * from usr");
            while (rs.next()){
                printWriter.println(rs.getString("username"));
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        PrintWriter pw=response.getWriter();
        String name=request.getParameter("name");
        String surname=request.getParameter("surname");

//        pw.println("<html>");
//        pw.println("<h3> Hello "+name+" "+surname+"</h3> ");
//        pw.println("</html>");
//
        // RequestDispatcher requestDispatcher=request.getRequestDispatcher("/firstJSP.jsp");
        //requestDispatcher.forward(request,response);
        //response.sendRedirect("https://google.com");
        //response.sendRedirect("/firstJSP.jsp");
    }
}
