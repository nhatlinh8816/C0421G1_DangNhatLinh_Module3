package repository;

import model.User;

import java.util.List;

public interface UserRepository {
    List<User> viewALlUser();
    void createUser(User user);
    boolean updateUser(User user);
    User selectUser(int id);
    boolean removeUser(User user);
    List<User> viewALlUserByCountry(String country);
    List<User> viewALlUserOrderByName();
}
