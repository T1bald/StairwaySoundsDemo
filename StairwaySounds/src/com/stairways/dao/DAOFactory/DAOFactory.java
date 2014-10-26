package com.stairways.dao.DAOFactory;

import com.stairways.dao.UserDAOImpl;

/**
 * Created by matvey on 26.10.14.
 */
public abstract class DAOFactory {

    public static final int MYSQL = 1;


    /*abstract getDAO methods*/
    public abstract UserDAOImpl getUserDAO();

    /* method returns DAOFactory depends on Database*/
    public static DAOFactory getDAOFactory(int RDBMS) {
        switch (RDBMS) {
            case MYSQL :
                return new MySqlDAOFactory();

            default :
                return null;

        }
    }

}
