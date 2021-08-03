package servlet;

import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet",urlPatterns = "")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //tự tạo dữ liệu
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(123,"Ronaldo","2000-02-13","Hà Nội","data\\ronaldo.jpg"));
        customerList.add(new Customer(223,"Lukaku","1990-05-14","Nghệ An","data\\lukaku.jpg"));
        customerList.add(new Customer(333,"Nguyễn Quang Hải","2004-02-13","Đà Nẵng","data\\quanghai.jpg"));
        customerList.add(new Customer(1453,"Nguyễn Công Phượng","1960-02-13","Huế","data\\congphuong.jpg"));
        //gửi dữ liệu sang file jsp để hiển thị
        request.setAttribute("customerListServlet",customerList);
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }
}
