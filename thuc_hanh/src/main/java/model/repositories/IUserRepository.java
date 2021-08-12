package model.repositories;

import model.bean.User;

import java.util.List;

public interface IUserRepository {
    public User findById(int id);
    List<User> display();
    public void createUser(User user);
    boolean remove(int id);
    boolean update (User user);
    public List<User> findByCountry (String country);
}
