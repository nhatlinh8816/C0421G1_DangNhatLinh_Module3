package controller;

import model.bean.User;
import model.repositories.UserRepository;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "UserServlet", urlPatterns = {"","/users"})
public class UserServlet extends javax.servlet.http.HttpServlet {
    UserService userService = new UserService();
    UserRepository userRepository = new UserRepository();
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                actionCreate(request,response);
                break;
            case "update":
                actionUpdate(request,response);
                break;
            case "remove":
                actionRemove(request,response);
                break;
        }

    }

    private void actionUpdate(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id,name,email,country);
        boolean result = this.userService.update(user);
            try {
                if (result) {
                    viewList(request,response);
                } else {
                    request.getRequestDispatcher("error-404.jsp").forward(request, response);
                }
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    private void actionRemove(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            boolean result = userService.remove(id);
            if (result){
                viewList(request,response);
            } else {
                request.getRequestDispatcher("error-404.jsp").forward(request,response);
            }

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void actionCreate(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name,email,country);
        userService.createUser(user);
        request.setAttribute("name",user);
        try {
            request.getRequestDispatcher("view/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                viewCreate(request,response);
                break;
            case "update":
                viewUpdate(request,response);
                break;
            case "remove":
                viewRemove(request,response);
                break;
            case "search":
                searchByCountry(request,response);
                break;
            default:
                viewList(request,response);
                break;
        }
    }

    private void searchByCountry(HttpServletRequest request, HttpServletResponse response) {
        String country = request.getParameter("country");
        List<User> list = null;
        list = this.userService.findByCountry(country);
        request.setAttribute("userList",list);
        try {
            request.getRequestDispatcher("view/view-list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            User user = this.userService.findById(id);
            request.setAttribute("user",user);
            request.getRequestDispatcher("view/update.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewRemove(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            User user = userService.findById(id);
            request.setAttribute("userRemove",user);
            request.getRequestDispatcher("view/remove.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewList(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = new ArrayList<>();
        userList = this.userRepository.display();
        request.setAttribute("userList",userList);
        try {
            request.getRequestDispatcher("view/view-list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
