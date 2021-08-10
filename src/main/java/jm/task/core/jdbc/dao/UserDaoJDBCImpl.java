package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Statement statement = Util.getConnection().createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS users (" +
                    "id INT NOT NULL AUTO_INCREMENT," +
                    " name VARCHAR(30) NOT NULL," +
                    "  lastName VARCHAR(30) NOT NULL," +
                    " age INT NOT NULL, PRIMARY KEY (id)");
        } catch (SQLException ignore) {
            System.out.println("1");
        }

    }

    public void dropUsersTable() {
        try (Statement statement = Util.getConnection().createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS users");
        } catch (SQLException ignored) {
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String mysql = "INSERT INTO users (name, lastName, age) Values (?, ?, ?)";
        try (PreparedStatement preparedStatement = Util.getConnection().prepareStatement(mysql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(1, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.execute();
            System.out.printf("User с именем – %s добавлен в базу данных\n", name);

        } catch (SQLException ignored) {
            System.out.println("Error");
        }
    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Statement statement = Util.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()) {
            }
        } catch (SQLException ignored) {
            System.out.println("3");
        }

        return users;
    }

    public void cleanUsersTable() {

    }
}
