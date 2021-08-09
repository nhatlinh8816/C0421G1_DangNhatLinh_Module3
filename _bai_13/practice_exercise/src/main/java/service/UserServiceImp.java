package service;

import model.User;

import java.util.List;

public interface UserServiceImp {
    List<User>viewAllUser();
    void createUser(User user);
    User selectUser(int id);
    boolean updateUser(int id, String newName, String newEmail, String newCountry);
    boolean removeUser(int id);
    List<User> viewALlUserByCountry(String country);
    List<User> viewALlUserOrderByName();
    String addUserTransaction();
}
