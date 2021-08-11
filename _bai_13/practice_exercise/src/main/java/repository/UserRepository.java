package repository;

import model.User;

import java.util.List;

public interface UserRepository {
    List<User> viewALlUser();
    void createUser(User user);
    boolean updateUser(int id, String newName, String newEmail, String newCountry);
    User selectUser(int id);
    boolean removeUser(int id);
    List<User> viewALlUserByCountry(String country);
    List<User> viewALlUserOrderByName();
    String addUserTransaction();
}
