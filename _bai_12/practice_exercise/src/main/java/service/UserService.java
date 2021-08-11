package service;

import model.User;

import java.util.List;

public interface UserService {
    List<User>viewAllUser();
    void createUser(User user);
    User selectUser(int id);
    boolean updateUser(User user);
    boolean removeUser(User user);
    List<User> viewALlUserByCountry(String country);
    List<User> viewALlUserOrderByName();
}
