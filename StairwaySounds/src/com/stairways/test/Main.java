package com.stairways.test;

import com.stairways.dao.MySqlDAO;
import com.stairways.dao.UserDAOImpl;
import com.stairways.model.User;

import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) {
//        Connector connector =
//                new Connector(Connector.DEFAULT_DRIVER, "root", "root",
//                        "jdbc:mysql://localhost:3306/stairway_sounds");
//        DataSourceConnector dataSourceConnector = DataSourceConnector.getInstance();
//        Connection connection = dataSourceConnector.getConnection();


        MySqlDAO<User> userDao = new UserDAOImpl();
        ResultSet resultSet = userDao.findAll();

        try {
            while (resultSet.next()) {
                System.out.println("id_user: " + resultSet.getInt("id_user") +
                        " email: " + resultSet.getString("email") + " name: "
                + resultSet.getString("username"));
            }

        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        }

}
