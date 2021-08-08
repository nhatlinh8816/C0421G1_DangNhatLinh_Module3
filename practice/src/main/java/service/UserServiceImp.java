package service;

import model.User;

import java.util.List;

public interface UserServiceImp {
    List<User>viewAllUser();
    void createUser(User user);
    User selectUser(int id);
    boolean updateUser(User user);
    boolean removeUser(User user);
}
