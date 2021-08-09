package repository;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements UserRepositoryImp {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<User> viewALlUser() {

        //tao 1 array list de nhan data
        List<User> userList = new ArrayList<>();
        try {
            // dung baseRes de ket noi java voi sql
            CallableStatement callableStatement
                    = baseRepository.getConnection().prepareCall("call display_all_user();");
            //truy van du lieu
            ResultSet resultSet = callableStatement.executeQuery();
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
    public boolean updateUser(int id, String newName, String newEmail, String newCountry) {
        int updateRow = 0;
        try {
            CallableStatement callableStatement
                    = baseRepository.getConnection().prepareCall("update `users`set `name` = ?,email =?,country =?  where id = ?");
            callableStatement.setString(1,newName);
            callableStatement.setString(2,newEmail);
            callableStatement.setString(3,newCountry);
            callableStatement.setString(4,id+"");
            updateRow = callableStatement.executeUpdate();
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
    public boolean removeUser(int id) {
        int deleteRow = 0;
        try {
            CallableStatement callableStatement
                    = baseRepository.getConnection().prepareCall("call delete_user(?);");
            callableStatement.setString(1,id+"");
            deleteRow = callableStatement.executeUpdate();
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

    @Override
    public String addUserTransaction() {
        String msg = "OK, transaction successful";
        Connection connection = this.baseRepository.getConnection();
        try {
            //tắt chế độ tự động commit (tự động đăng ký dữ liệu trong DB)

            connection.setAutoCommit(false);
            //them record cho bang typeOfCountry
            PreparedStatement preparedStatement_typeOfCountry
                    = connection.prepareStatement("insert into type_of_country(id,`name`) values(?,?);");
            preparedStatement_typeOfCountry.setString(1,"5");
            preparedStatement_typeOfCountry.setString(2,"Australia");
            int rowInsert = preparedStatement_typeOfCountry.executeUpdate();

            //them record cho bang Country
            PreparedStatement preparedStatement_country
                    = connection.prepareStatement("insert into country(id,`name`,type_of_country_id) values(?,?,?);");
            preparedStatement_country.setString(1,"5");
            preparedStatement_country.setString(2,"New Zealand");
            preparedStatement_country.setString(3,"5");
            rowInsert += preparedStatement_country.executeUpdate();

            //nếu 2 rowInsert trên đc add thành công thì add thêm user
            if (rowInsert==2){
                PreparedStatement preparedStatement_user
                        = connection.prepareStatement("insert into users(id,name, email, country) values(?,?,?,?);");
                preparedStatement_user.setString(1,"5");
                preparedStatement_user.setString(2,"Cahill");
                preparedStatement_user.setString(3,"Cahill@gmail.aus");
                preparedStatement_user.setString(4,"New Zealand");
                rowInsert += preparedStatement_user.executeUpdate();
            }
            //nếu user đc add thành công thì mới commit dữ liệu vào DB
            if (rowInsert==3){
                connection.commit();
            }else {
                msg = "rollback try";
                connection.rollback();
            }

        } catch (SQLException e) {
            try {
                msg= "rollback catch";
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return msg;
    }
}
