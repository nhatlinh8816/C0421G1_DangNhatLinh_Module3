package controller.servlet;

import model.User;
import service.UserService;
import service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//tao 1 url "" de lay quyen trang chu
@WebServlet(name = "UserServlet",urlPatterns = {"","/users"})
public class UserServlet extends HttpServlet {
    //tao 1 doi tuong userSerImp de thuc hien cac chuc nang;
    UserServiceImp userServiceImp = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionClient = request.getParameter("actionClient");
        if (actionClient==null){
            actionClient ="";
        }
            switch (actionClient){
                case "create":
                    saveNewUser(request);
                    viewAllUser(request,response);
                    break;
                case "update":
                    int id =Integer.parseInt(request.getParameter("UserId")) ;
                    String updateName = request.getParameter("UserName");
                    String updateEmail = request.getParameter("UserEmail");
                    String updateCountry = request.getParameter("UserCountry");
                    User updateUser = new User();

                    //update lai thong tin theo nhu du lieu vua moi sua
                    updateUser.setId(id);
                    updateUser.setName(updateName);
                    updateUser.setEmail(updateEmail);
                    updateUser.setCountry(updateCountry);
                    if (userServiceImp.updateUser(id,updateName,updateEmail,updateCountry)) {
                        request.setAttribute("msg","Update Successfully");
                        viewAllUser(request,response);
                    }else {
                        request.setAttribute("msg", "Update Failed ");
                        request.setAttribute("SelectUser", updateUser);
                        request.getRequestDispatcher("update.jsp").forward(request,response);
                    }
                    break;
                case "delete":
                    int deleteId =Integer.parseInt(request.getParameter("UserId")) ;
                    userServiceImp.removeUser(deleteId);
                    viewAllUser(request,response);
                    break;
                case "viewByCountry":
                    viewAllUserByCountry(request,response);
                    break;
                    }
        }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
        String actionClient = request.getParameter("actionClient");
        if (actionClient==null){
            actionClient ="";
        }
            switch (actionClient){
                case "create":
                    createFormNewUser(request,response);
                    break;
                case "view":
                    viewUser(request,response);
                    break;
                case "update":
                    formUpdateUser(request,response);
                    break;
                case "delete":
                    formRemoveUser(request,response);
                    break;
                case "orderByName":
                    viewAllUserOrderByName(request,response);
                    break;
                case "transaction":
                    String msg = userServiceImp.addUserTransaction();
                    request.setAttribute("msgInfo",msg);
                    try {
                        request.getRequestDispatcher("result_transaction.jsp").forward(request,response);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    viewAllUser(request,response);
            }
        }

    //phuong thuc chon 1 user de xem,sua,xoa
    protected void selectUser(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("userId")) ;
        request.setAttribute("SelectUser",userServiceImp.selectUser(id));
    }

    //phuong thuc hien thi tat ca cac user;
    protected void viewAllUser(HttpServletRequest request, HttpServletResponse response){
        //thuc hien truyen du lieu sang tang view trong MVC
        request.setAttribute("UserListServlet",userServiceImp.viewAllUser());
        //tao 1 file list.jsp de hien thi du lieu tren;
        try {
            request.getRequestDispatcher("list.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    //phuong thuc chuyen  sang 1 form de them user;

    protected void createFormNewUser(HttpServletRequest request, HttpServletResponse response){
        try {
            request.getRequestDispatcher("create.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    //tao phuong thuc luu du lieu user duoc them tu FormNewUser;
    protected void saveNewUser(HttpServletRequest request){
        //tao bien de nhan du lieu moi duoc them vao:
        int newID = Integer.parseInt(request.getParameter("newId"));
        String newName = request.getParameter("newName");
        String newEmail = request.getParameter("newEmail");
        String newCountry = request.getParameter("newCountry");

        //tao 1 doi tuong user nhan cac bien tren;
        User newUser = new User(newID,newName,newEmail,newCountry);

        //luu du lieu vao database;
        userServiceImp.createUser(newUser);
    }


    //tao 1 view de xem 1 user;
    protected void viewUser(HttpServletRequest request, HttpServletResponse response){
        selectUser(request);
        try {
            request.getRequestDispatcher("view.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    //tao 1 form de update 1 user;
    protected void formUpdateUser(HttpServletRequest request, HttpServletResponse response){
        selectUser(request);
        try {
            request.getRequestDispatcher("update.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    //phuong thuc luu lai thong tin user vua update tu form:

    protected void formRemoveUser(HttpServletRequest request, HttpServletResponse response){
        selectUser(request);
        try {
            request.getRequestDispatcher("remove.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }



    //phuong thuc hien thi tat ca cac user theo quoc gia;
    protected void viewAllUserByCountry(HttpServletRequest request, HttpServletResponse response){
        String country = request.getParameter("UserCountry");
        request.setAttribute("UserListServletByCountry",userServiceImp.viewALlUserByCountry(country));
        try {
            request.getRequestDispatcher("listByCountry.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    //phuong thuc hien thi tat ca cac user sap xep theo ten;
    protected void viewAllUserOrderByName(HttpServletRequest request, HttpServletResponse response){
        //thuc hien truyen du lieu sang tang view trong MVC
        request.setAttribute("UserListServletOrderByName",userServiceImp.viewALlUserOrderByName());
        //tao 1 file listOrderByName.jsp de hien thi du lieu tren;
        try {
            request.getRequestDispatcher("listOrderByName.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
