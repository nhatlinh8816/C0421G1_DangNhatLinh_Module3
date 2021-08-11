package controller.servlet;

import model.bean.Customer;
import service.customer.CustomerService;
import service.customer.CustomerServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerServlet",urlPatterns = {"/customers"})
public class CustomerServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionClient = request.getParameter("actionClient");
        if (actionClient==null){
            actionClient ="";
        }
        switch (actionClient){
            case "create":
                saveCustomer(request,response);
                viewAllCustomer(request,response);
                break;
//            case "viewAll":
//                viewAllCustomer(request,response);
//                break;
//            case "update":
//                formUpdateUser(request,response);
//                break;
//            case "delete":
//                formRemoveUser(request,response);
//                break;
//            case "orderByName":
//                viewAllUserOrderByName(request,response);
//                break;
//            default:
//                viewAllUser(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionClient = request.getParameter("actionClient");
        if (actionClient==null){
            actionClient ="";
        }
        switch (actionClient){
            case "create":
                createFormCustomer(request,response);
                break;
            case "viewAll":
                viewAllCustomer(request,response);
                break;
//            case "update":
//                formUpdateUser(request,response);
//                break;
//            case "delete":
//                formRemoveUser(request,response);
//                break;
//            case "orderByName":
//                viewAllUserOrderByName(request,response);
//                break;
//            default:
//                viewAllUser(request,response);
        }
    }
    protected void createFormCustomer(HttpServletRequest request,HttpServletResponse response){
        try {
            request.getRequestDispatcher("customerCRUD/createForm.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void saveCustomer(HttpServletRequest request,HttpServletResponse response){

    }

    protected void viewAllCustomer(HttpServletRequest request,HttpServletResponse response){
        request.setAttribute("CustomerListServlet", customerService.viewAllCustomer());
        try {
            request.getRequestDispatcher("customerCRUD/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void saveNewCustomer(HttpServletRequest request, HttpServletResponse response){
        //tao bien de nhan du lieu moi duoc them vao:
        Integer newType = Integer.parseInt(request.getParameter("newCustomerType"));
        String newName =  request.getParameter("newCustomerName");
        Integer newGender = Integer.parseInt(request.getParameter("newCustomerGender"));
        String newCode = request.getParameter("newCustomerCode");
        String newDateOfBirth = request.getParameter("newCustomerDOB");
        String newIdentify = request.getParameter("newCustomerIdentify");
        String newPhoneNumber = request.getParameter("newCustomerPhoneNumber");
        String newEmail = request.getParameter("newCustomerEmail");
        String newAddress = request.getParameter("newCustomerAddress");


        //tao 1 doi tuong user nhan cac bien tren;
        Customer newCustomer = new Customer
                (newType,newName,newGender,newCode,newDateOfBirth,newIdentify,newPhoneNumber,newEmail,newAddress);

        //luu du lieu vao database;
        customerService.createCustomer(newCustomer);
    }
}
