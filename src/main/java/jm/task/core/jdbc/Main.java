package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();

        userService.saveUser("Николай", "Тараскин", (byte) 22);
        userService.saveUser("Анна", "Дьячкова", (byte) 24);
        userService.saveUser("Варвара", "Синичкина", (byte) 24);
        userService.saveUser("Константин", "Сапрыкин", (byte) 25);

        System.out.println(userService.getAllUsers());

        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
