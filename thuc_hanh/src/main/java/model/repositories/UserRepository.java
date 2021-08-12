package model.repositories;

import model.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public User findById(int id) {
        User user = null;
        try {
            // cú pháp thực hiện câu truy vấn
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
                    "SELECT `name`,email,country\n" +
                    "from users\n" +
                    "WHERE id = ?;");
            // gán biến id cho dối tượng --> de truyen gia tri cho cai bien' dau ?"
            preparedStatement.setString(1, id + "");
            // thực hiện câu truy vấn
            ResultSet resultSet = preparedStatement.executeQuery(); //--> bat buoc khi thuc truy van select
            if (resultSet.next()) {
                user = new User();
                user.setId(id);
                user.setName(resultSet.getString("name")); // resultSet.GetString --> trả về giá trị ở record
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> display() {
        List<User> userList = new ArrayList<>();
        User user = null;
        try {
            // thuc hien cau truy van sql
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement("" +
                            "SELECT id,`name`,email,country\n" +
                            "FROM `users`");
//            preparedStatement.setString(1,?+""); --> ung dung khi su dung bien dong.
            ResultSet resultSet = preparedStatement.executeQuery(); // --> resultSet dung hung du lieu khi truy van
            while (resultSet.next()) {
                user = new User();
                user.setId(Integer.parseInt(resultSet.getString("id")));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                userList.add(user);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public void createUser(User user) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
                    "INSERT INTO users (`name`, email, country)\n" +
                    "VALUES (?,?,?);");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate(); // --> .executeUpdate() update, create , remove .....
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean remove(int id) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
                    "DELETE FROM `users` \n" +
                    "WHERE id = ?");
            preparedStatement.setInt(1, id);
            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
                    "UPDATE `users`\n" +
                    "SET `name` = ?, email = ?, country = ?\n" +
                    "WHERE id = ?;");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, user.getId());
            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> findByCountry(String country) {
        List<User> userList = new ArrayList<>();
        try {
            User user = null;
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
                    "SELECT id,`name`,email,country\n" +
                    "from users\n" +
                    "WHERE country = ?;");
            preparedStatement.setString(1, country);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }
}
