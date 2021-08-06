package service;

import dao.IUserDAO;
import dao.UserDAO;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService implements UserServiceImp {
    IUserDAO iUserDAO = new UserDAO();
    @Override
    public String updateUser(User user) throws SQLException {
        String msg = null;
        if (user.getName().matches("[A-Za-z ]+")
                &&user.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")
                &&user.getCountry().matches("[A-Za-z ]+")) {
           msg = iUserDAO.updateUser(user);
        }else {
            msg = "failed";
        }
        return msg;
    }

    @Override
    public User selectUser(int id) {
        return iUserDAO.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return iUserDAO.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return iUserDAO.deleteUser(id);
    }

    @Override
    public void createUser(User user) throws SQLException {
         iUserDAO.createUser(user);
    }

    @Override
    public User selectUserByCountry(String country) {
        return iUserDAO.selectUserByCountry(country);
    }

    @Override
    public List<User> viewUserByCountry(String country) {
        return iUserDAO.viewUserByCountry(country);
    }
}
