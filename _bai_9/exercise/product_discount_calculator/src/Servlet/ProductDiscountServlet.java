package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductDiscountServlet",urlPatterns = "/discount_servlet")
public class ProductDiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double listPrice = Double.parseDouble ( request.getParameter("listPrice"));
        double discountPercent = Double.parseDouble( request.getParameter("discountPercent"));
        double discountAmount = listPrice*discountPercent*0.01;
        double discountPrice = listPrice - discountAmount;
        String describe = request.getParameter("descriptionProduct");
        //tạo 1 file mới
        request.setAttribute("discountAmount",discountAmount);
        request.setAttribute("discountPrice",discountPrice);
        request.setAttribute("descriptionProduct",describe);
        request.getRequestDispatcher("result.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
