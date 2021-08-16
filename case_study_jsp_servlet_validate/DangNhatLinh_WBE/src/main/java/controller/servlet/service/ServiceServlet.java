package controller.servlet.service;

import model.bean.service.Service;
import model.service.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServiceServlet",urlPatterns = "/model/service")
public class ServiceServlet extends HttpServlet {
    ServiceService serviceService = new ServiceServiceImp();
    ServiceTypeRentService serviceTypeRentService = new ServiceTypeRentServiceImp();
    ServiceTypeService serviceTypeService = new ServiceTypeServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionClient = request.getParameter("actionClient");
        if (actionClient==null){
            actionClient ="";
        }
        switch (actionClient){
            case "create":
                saveService(request,response);
                viewAllService(request,response);
                break;
        }
    }

    protected void saveService(HttpServletRequest request, HttpServletResponse response){
        String newName = request.getParameter("newServiceName");
        int newArea =Integer.parseInt(request.getParameter("newServiceArea")) ;
        double newCost =Double.parseDouble(request.getParameter("newServiceCost")) ;
        int newPerson =Integer.parseInt(request.getParameter("newServicePerson"));
        int newServiceTypeOfRent =Integer.parseInt(request.getParameter("newServiceTypeOfRent"));
        int newServiceTypeOfService =Integer.parseInt(request.getParameter("newServiceTypeOfService"));
        String newServiceStandard =request.getParameter("newServiceStandard");
        String newServiceDescription =request.getParameter("newServiceDescription");
        double newServicePoolArea =Double.parseDouble(request.getParameter("newServicePoolArea"));
        int newServiceFloor =Integer.parseInt(request.getParameter("newServiceFloor"));

        Service newService = new Service(newName,newArea,newCost,newPerson,newServiceTypeOfRent
                ,newServiceTypeOfService,newServiceStandard,newServiceDescription,newServicePoolArea,newServiceFloor);

        serviceService.createService(newService);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionClient = request.getParameter("actionClient");
        if (actionClient==null){
            actionClient ="";
        }
        switch (actionClient){
            case "viewAll":
               viewAllService(request,response);
               break;
            case "create":
                createFormService(request,response);
                break;
        }
    }

    protected void viewAllService(HttpServletRequest request,HttpServletResponse response){
        request.setAttribute("ServiceList",serviceService.viewAllService());
        try {
            request.getRequestDispatcher("CRUD/serviceCRUD/listService.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void createFormService(HttpServletRequest request,HttpServletResponse response){
        request.setAttribute("ServiceTypeRentList",serviceTypeRentService.viewAll());
        request.setAttribute("ServiceTypeServiceList",serviceTypeService.viewAll());
        try {
            request.getRequestDispatcher("CRUD/serviceCRUD/createService.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
