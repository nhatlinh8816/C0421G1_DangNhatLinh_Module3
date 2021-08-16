package model.repository;

import model.bean.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepositoryImpl implements StudentRepository {

    private static final String INSERT_STUDENT = "INSERT INTO student(`name` , gender, `point`,  image) \n" +
            " VALUES (?,?,?,?) ";
    private static final String SELECT_ALL_STUDENT = "SELECT * FROM student;";

    private static final String SELECT_STUDENT_BY_ID = "SELECT * FROM student WHERE id = ? ;";

    private static final String DELETE_STUDENT = "DELETE from student where id = ?;";
    public StudentRepositoryImpl() {
    }

    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_STUDENT);
                resultSet = statement.executeQuery();

                Student student = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString("name");
                    int gender = resultSet.getInt("gender");
                    int point = resultSet.getInt("point");
                    String image = resultSet.getString("image");
                    student = new Student(id, name, gender, point, image);
                    studentList.add(student);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return studentList;
    }

    @Override
    public void save(Student student) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(INSERT_STUDENT);
            statement.setString(1, student.getName());
            statement.setInt(2, student.getGender());
            statement.setInt(3, student.getPoint());
            statement.setString(4, student.getImage());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            DBConnection.close();
        }
    }

    @Override
    public Student findById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Student student = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_STUDENT_BY_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                int id_stu = resultSet.getInt(1);
                String name = resultSet.getString("name");
                int gender = resultSet.getInt("gender");
                int point = resultSet.getInt("point");
                String image = resultSet.getString("image");
                student = new Student(id_stu, name, gender, point, image);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return student;
    }

    @Override
    public void remove(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try{
            statement  = connection.prepareStatement(DELETE_STUDENT);
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            DBConnection.close();
        }
    }
}
