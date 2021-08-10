package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

        private static Connection connection;
        final static String url = "jdbc:mysql://localhost:3306/pp113";
        final static String userName = "root";
        final static String pass = "/12Arbat7322534";

    public static Connection getConnection() {
        if (connection == null) {
            try {
            connection = DriverManager.getConnection(url, userName, pass);
            } catch (SQLException ignore) {
                System.out.println("2");
            }
        }
        return connection;
    }
}
