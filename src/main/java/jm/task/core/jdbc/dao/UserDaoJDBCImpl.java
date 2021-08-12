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
/*
        String mysql = "CREATE TABLE IF NOT EXISTS users (" +
                "id INT NOT NULL AUTO_INCREMENT," +
                " name VARCHAR(30) NOT NULL," +
                "  lastName VARCHAR(30) NOT NULL," +
                " age INT NOT NULL, PRIMARY KEY (id))";
        try (Statement statement = Util.getConnection().createStatement()) {
            statement.execute(mysql);
        } catch (SQLException e) {
            System.out.println("createError");
        }
*/

    }

    public void dropUsersTable() {
/*        try (Statement statement = Util.getConnection().createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS users");
        } catch (SQLException e) {
            System.out.println("dropError");
        }*/
    }

    public void saveUser(String name, String lastName, byte age) {
/*        String mysql = "INSERT INTO users (name, lastName, age) Values (?, ?, ?)";
        try (PreparedStatement preparedStatement = Util.getConnection().prepareStatement(mysql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.execute();
            System.out.printf("User с именем – %s добавлен в базу данных\n", name);

        } catch (SQLException e) {
            System.out.println("saveError");
        }*/
    }

    public void removeUserById(long id) {
/*
        String mysql = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement preparedStatement = Util.getConnection().prepareStatement(mysql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("removeError");
        }
*/

    }

    public List<User> getAllUsers() {
/*        List<User> users = new ArrayList<>();
        try (Statement statement = Util.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("getError");
        }

        return users;*/
        return null;
    }

    public void cleanUsersTable() {
/*
        try (Statement statement = Util.getConnection().createStatement()) {
            statement.execute("DELETE FROM users");
        } catch (SQLException e) {
            System.out.println("cleanError");
        }
*/


    }
}
