package com.stairways.dao.DAOFactory;

import com.stairways.dao.UserDAOImpl;
import com.stairways.jdbc.MySqlDataSourceConnector;

import java.sql.Connection;

/**
 * Created by matvey on 26.10.14.
 */
public class MySqlDAOFactory extends DAOFactory{

public static Connection createConnection() {
    Connection connection = MySqlDataSourceConnector.getConnection();
    return connection;
}

@Override
public UserDAOImpl getUserDAO() {
    return new UserDAOImpl();
}


}
