package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.*;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        Transaction transaction;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String mysql = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT NOT NULL AUTO_INCREMENT," +
                    " name VARCHAR(30) NOT NULL," +
                    " lastName VARCHAR(30) NOT NULL," +
                    " age INT NOT NULL, PRIMARY KEY (id))";

            session.createNativeQuery(mysql).addEntity(User.class);//addentity прочитать
            transaction.commit();
        } catch (Exception e) {
            System.out.println("createError");
        }
    }

    @Override
    public void dropUsersTable() {
        Transaction transaction;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createNativeQuery("DROP TABLE IF EXISTS users");
            transaction.commit();
        } catch (Exception e) {
            System.out.println("dropError");
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(new User(name, lastName, age));
            transaction.commit();
            System.out.printf("User с именем – %s добавлен в базу данных\n", name);
        } catch (Exception e) {
            System.out.println("saveError");
        }
    }

    @Override
    public void removeUserById(long id) {
        Transaction transaction;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(session.get(User.class, id));
            transaction.commit();
        } catch (Exception e) {
            System.out.println("saveError");
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Transaction transaction;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            users = session.createQuery("FROM User").list();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("getAllError");
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
           List<User> users = session.createQuery("FROM User").list();
            for (User user : users) {
                session.delete(user);
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("cleanError");
        }
    }
}
