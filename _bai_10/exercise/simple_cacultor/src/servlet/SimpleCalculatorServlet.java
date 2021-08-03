package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SimpleCalculatorServlet",urlPatterns = "/calculator")
public class SimpleCalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double numberOne = Double.parseDouble(request.getParameter("numberOne"));
        double numberTwo = Double.parseDouble(request.getParameter("numberTwo"));
        String operator = request.getParameter("Operator");
        request.setAttribute("numberOne",numberOne);
        request.setAttribute("numberTwo",numberTwo);
        if (operator.equals("addition")){
            String subtend = "+";
            double result = numberOne+numberTwo;
            request.setAttribute("Subtend",subtend);
            request.setAttribute("Result",result);
            request.getRequestDispatcher("result.jsp").forward(request,response);
        }
        if (operator.equals("subtraction")){
            String subtend = "-";
            double result = numberOne-numberTwo;
            request.setAttribute("Subtend",subtend);
            request.setAttribute("Result",result);
            request.getRequestDispatcher("result.jsp").forward(request,response);
        }
        if (operator.equals("multiplication")){
            String subtend = "x";
            double result = numberOne*numberTwo;
            request.setAttribute("Subtend",subtend);
            request.setAttribute("Result",result);
            request.getRequestDispatcher("result.jsp").forward(request,response);
        }
        if (operator.equals("divide")) {
            String subtend = "/";
            try {
                double result = numberOne / numberTwo;
                request.setAttribute("Result", result);
                }
            catch (Exception e) {
                System.out.println("Có lỗi"+ e);
            }
            request.setAttribute("Subtend", subtend);
            request.getRequestDispatcher("result.jsp").forward(request, response);
            }
        }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
