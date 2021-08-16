package controller;

import model.bean.Student;
import model.service.StudentService;
import model.service.StudentServiceImpl;
import model.service.commons.Validate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@WebServlet(name = "StudentServlet", urlPatterns = {"", "/student"})
public class StudentServlet extends HttpServlet {

    private StudentService service = new StudentServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionClient");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createStudent(request, response);
                break;
            case "delete":
                deleteStudent(request, response);
                break;
            default:
                showStudentList(request, response);
        }
    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int gender = Integer.parseInt(request.getParameter("gender"));
        String stringPoint = request.getParameter("point");
        if(!Validate.validateNumber(stringPoint)){
            request.setAttribute("messPoint", "Point required number");
            showCreatePage(request,response);
        }
        int point = Integer.parseInt(stringPoint);
        String name = request.getParameter("name");
        String image = "no_photo.jpg";
        Student newStudent = new Student( name, gender, point, image);
        Map<String, String> mapMessage = service.save(newStudent);
        if (mapMessage.isEmpty()){
            showStudentList(request, response);
        }else {
            request.setAttribute("map", mapMessage);
//            request.setAttribute("messPoint", mapMessage.get("point"));
            request.setAttribute("student", newStudent);
            showCreatePage(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionClient");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showCreatePage(request, response);
                break;
            case "delete":
                deleteStudent(request, response);
                break;
            default:
                showStudentList(request, response);
        }

    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        service.remove(id);
        response.sendRedirect("/student");
//        showStudentList(request, response);
    }

    private void showCreatePage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        response.sendRedirect("/student/create.jsp");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/student/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showStudentList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setAttribute("studentList", service.findAll());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/student/list.jsp");
        requestDispatcher.forward(request, response);
    }
}
