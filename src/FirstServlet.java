import logic.Cart;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");
        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        if (cart == null) {
            cart = new Cart();
            cart.setName(name);
            cart.setQuantity(quantity);
        }
        session.setAttribute("cart", cart);
        getServletContext().getRequestDispatcher("/showCart.jsp").forward(request, response);

//        PrintWriter pw=response.getWriter();
//        String name=request.getParameter("name");
//        String surname=request.getParameter("surname");
//
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
