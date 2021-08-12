package controller.servlet.customer;

import model.bean.customer.Customer;
import model.bean.customer.CustomerType;
import service.customer.CustomerService;
import service.customer.CustomerServiceImp;
import service.customer.CustomerTypeService;
import service.customer.CustomerTypeServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerServlet",urlPatterns = {"/customers"})
public class CustomerServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImp();
    CustomerTypeService customerTypeService = new CustomerTypeServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionClient = request.getParameter("actionClient");
        if (actionClient==null){
            actionClient ="";
        }
        switch (actionClient){
            case "create":
                saveNewCustomer(request,response);
                viewAllCustomer(request,response);
                break;
//            case "viewAll":
//                viewAllCustomer(request,response);
//                break;
            case "update":
                Customer updateCustomer;
                updateCustomer = targetCustomer(request);
                if (customerService.updateCustomer(updateCustomer)){
                    request.setAttribute("msg","Update Sucessfully");
                    request.getRequestDispatcher("CRUD/customerCRUD/update.jsp").forward(request,response);
                }else {
                    request.setAttribute("msg","Update Failed");
                    request.setAttribute("UpdateFailedUser",updateCustomer);
                    request.getRequestDispatcher("CRUD/customerCRUD/update.jsp").forward(request,response);
                }
                createFormCustomer(request,response);
                break;
            case "delete":
                int deleteId =Integer.parseInt( request.getParameter("id"));
                if (customerService.deleteCustomer(deleteId)){
                    request.setAttribute("msg","Delete Sucessfully");
                    viewAllCustomer(request,response);
                }else {
                    request.setAttribute("msg","Delete Failed");
                    viewAllCustomer(request,response);
                }


                break;
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
            case "update":
                formUpdateCustomer(request,response);
                break;
//            case "delete":
//                int deleteId =Integer.parseInt( request.getParameter("customerId"));
//                customerService.deleteCustomer(deleteId);
//                viewAllCustomer(request,response);
//                break;
//            case "orderByName":
//                viewAllUserOrderByName(request,response);
//                break;
//            default:
//                viewAllUser(request,response);
        }
    }
    //phuong thuc chon 1 customer de xem,sua,xoa
    protected void selectCustomer(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("customerId")) ;
        request.setAttribute("SelectCustomer", customerService.selectCustomer(id));
    }
    protected void createFormCustomer(HttpServletRequest request,HttpServletResponse response){
        request.setAttribute("CustomerTypeList",customerTypeService.viewAllCustomerType());
        try {
            request.getRequestDispatcher("CRUD/customerCRUD/createForm.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    protected void viewAllCustomer(HttpServletRequest request,HttpServletResponse response){
        request.setAttribute("CustomerListServlet", customerService.viewAllCustomer());
        try {
            request.getRequestDispatcher("CRUD/customerCRUD/list1.jsp").forward(request,response);
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
        boolean newGender = Boolean.parseBoolean(request.getParameter("newCustomerGender"));
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

    //tao 1 form de update 1 user;
    protected void formUpdateCustomer(HttpServletRequest request, HttpServletResponse response){
        selectCustomer(request);
        try {
            request.getRequestDispatcher("CRUD/customerCRUD/update.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    protected Customer targetCustomer(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("CustomerId")) ;
        int type =Integer.parseInt(request.getParameter("newCustomerType")) ;
        String name = request.getParameter("newCustomerName");
        boolean gender =Boolean.parseBoolean(request.getParameter("newCustomerGender"));
        String code = request.getParameter("newCustomerCode");
        String dOB = request.getParameter("newCustomerDOB");
        String identify = request.getParameter("newCustomerIdentify");
        String phoneNumber = request.getParameter("newCustomerPhoneNumber");
        String email = request.getParameter("newCustomerEmail");
        String address = request.getParameter("newCustomerAddress");
        Customer targetCustomer = new Customer();

        targetCustomer.setIdCustomer(id);
        targetCustomer.setTypeCustomer(type);
        targetCustomer.setNameCustomer(name);
        targetCustomer.setGenderCustomer(gender);
        targetCustomer.setCodeCustomer(code);
        targetCustomer.setDateOfBirthCustomer(dOB);
        targetCustomer.setIdentifyCodeCustomer(identify);
        targetCustomer.setPhoneNumberCustomer(phoneNumber);
        targetCustomer.setEmailCustomer(email);
        targetCustomer.setAddressCustomer(address);

        return targetCustomer;

    }


}
