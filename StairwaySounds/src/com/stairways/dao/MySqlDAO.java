package com.stairways.dao;

import com.stairways.dao.DAOFactory.MySqlDAOFactory;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by matvey on 14.10.14.
 */
public interface MySqlDAO<T> {

    public List<T> findAll();
    public T getById(int id);
    public void insert(T value);
    public void update(T value);

}
