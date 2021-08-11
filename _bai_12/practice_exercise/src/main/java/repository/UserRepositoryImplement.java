package repository;

import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImplement implements UserRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<User> viewALlUser() {

        //tao 1 array list de nhan data
        List<User> userList = new ArrayList<>();
        try {
            // dung baseRes de ket noi java voi sql
            PreparedStatement preparedStatement
                    = baseRepository.getConnection().prepareStatement("select id,name,email,country from `users`;");
            //truy van du lieu
            ResultSet resultSet = preparedStatement.executeQuery();
            //khoi tao doi tuong user de lay du lieu tu resultset
            User user = null;
            //chay vong lap de xuat tung dong du lieu tu resultset vao user;
            while (resultSet.next()){
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

    @Override
    public void createUser(User user) {
        try {
            PreparedStatement preparedStatement
                    = baseRepository.getConnection().prepareStatement("insert into `users` (id,name, email, country) value (?,?,?,?)");
            preparedStatement.setString(1,user.getId()+"");
            preparedStatement.setString(2,user.getName());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setString(4,user.getCountry());
            System.out.println(user);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public boolean updateUser(User user) {
        int updateRow = 0;
        try {
            PreparedStatement preparedStatement
                    = baseRepository.getConnection().prepareStatement("update `users`set `name` = ?,email =?,country =?  where id = ?");
            preparedStatement.setString(4,user.getId()+"");
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getCountry());
            updateRow = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return updateRow>0? true:false;
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        try {
            // dung baseRes de ket noi java voi sql
            PreparedStatement preparedStatement
                    = baseRepository.getConnection().prepareStatement("select id,name,email,country from `users` where id=?");
            preparedStatement.setString(1,id+"");
            //truy van du lieu
            ResultSet resultSet = preparedStatement.executeQuery();

            //xuat du lieu vua moi truy van duoc
            if (resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean removeUser(User user) {
        int deleteRow = 0;
        try {
            PreparedStatement preparedStatement
                    = baseRepository.getConnection().prepareStatement("delete from `users` where id = ?");
            preparedStatement.setString(1,user.getId()+"");
            deleteRow = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return deleteRow>0? true:false;
    }

    @Override
    public List<User> viewALlUserByCountry(String country) {
        //tao 1 array list de nhan data
        List<User> userListByCountry = new ArrayList<>();
        try {
            // dung baseRes de ket noi java voi sql
            PreparedStatement preparedStatement
                    = baseRepository.getConnection().prepareStatement("select id,name,email,country from `users` where country =?");

            preparedStatement.setString(1,country);
            //truy van du lieu
            ResultSet resultSet = preparedStatement.executeQuery();
            //khoi tao doi tuong user de lay du lieu tu resultset
            User user = null;
            //chay vong lap de xuat tung dong du lieu tu resultset vao user;
            while (resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                userListByCountry.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userListByCountry;
    }

    @Override
    public List<User> viewALlUserOrderByName() {

        //tao 1 array list de nhan data
        List<User> userListOrderByName = new ArrayList<>();
        try {
            // dung baseRes de ket noi java voi sql
            PreparedStatement preparedStatement
                    = baseRepository.getConnection().prepareStatement("select id,name,email,country from `users` order by name;");
            //truy van du lieu
            ResultSet resultSet = preparedStatement.executeQuery();
            //khoi tao doi tuong user de lay du lieu tu resultset
            User user = null;
            //chay vong lap de xuat tung dong du lieu tu resultset vao user;
            while (resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                userListOrderByName.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userListOrderByName;
    }
}
