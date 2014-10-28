package com.stairways.dao;

import com.stairways.dao.DAOFactory.MySqlDAOFactory;
import com.stairways.model.Tracks;
import com.stairways.model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by matvey on 14.10.14.
 */
public class UserDAOImpl implements MySqlDAO<Users> {

Connection connection = MySqlDAOFactory.createConnection();

@Override
public List<Users> findAll() {
    List<Users> usersList = null;
    ResultSet rs = null;
    try {

        PreparedStatement prst = connection.prepareStatement("Select * from users");
        rs = prst.executeQuery();
        usersList = (List<Users>) rs;

    } catch (Exception ex) {
        ex.printStackTrace();
        return usersList;
    }

    return usersList;
}

@Override
public Users findById(int id) {
    Users user = null;

    try {
        PreparedStatement prst = connection.prepareStatement("Select * from users WHERE id_user = ?");
        prst.setInt(1, id);
        ResultSet rs = prst.executeQuery();
        user = resultSetToUser(rs);

    } catch (Exception ex) {
        ex.printStackTrace();
        return null;
    }

    return user;
}

@Override
public void insert(Users value) {
    try {
        PreparedStatement preparedStatement =
                connection.prepareStatement("insert into users " +
                        "(user_id, email, udername , " +
                        "pass_hash, pass_salt, role_id) values (?,?,?,?,?,?)");

        int resultExecute = executePrepareStatement(preparedStatement, value);

        if (resultExecute == 1)
            System.out.println("Success Insertion!");

    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

@Override
public void update(Users value) {
    try {
        PreparedStatement preparedStatement =
                connection.prepareStatement("update users set id=?," +
                        " email = ?, username = ?, pass_hash = ?, pass_salt= ?, role_id =?");
        int executeResult = executePrepareStatement(preparedStatement, value);

        if (executeResult == 1)
            System.out.println("Update Succeed!");

    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

public Users findByUserName(String userName) {

    ResultSet rs;
    Users user = null;

    try {
        PreparedStatement prst =
                connection.prepareStatement("Select * from users WHERE username = ?");

        prst.setString(1, userName);
        rs = prst.executeQuery();

        user = resultSetToUser(rs);

    } catch (Exception ex) {
        ex.printStackTrace();
        return null;
    }

    return user;

}

public Users findByEmail(String email) {

    ResultSet rs;
    Users user = null;

    try {

        PreparedStatement prst =
                connection.prepareStatement("Select * from users WHERE email = ?");
        prst.setString(1, email);

        rs = prst.executeQuery();

        user = resultSetToUser(rs);

    } catch (Exception ex) {
        ex.printStackTrace();
        return null;
    }

    return user;

    }

private Users resultSetToUser(ResultSet resultSet) {

        Users user = new Users();
        try {

        while (resultSet.next()) {
            user = new Users();

            user.setIdUser(resultSet.getInt("id_user"));
            user.setEmail(resultSet.getString("email"));
            user.setUsername(resultSet.getString("username"));
            user.setPassHash(resultSet.getString("pass_hash"));
            user.setPassSalt(resultSet.getString("pass_salt"));
            user.setRoleId(resultSet.getInt("role_id"));

        }
            } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            return user;
        }

        return user;
    }

private int executePrepareStatement(PreparedStatement stmt,
            Users value) {
        int result;

        try {
            stmt.setInt(1, value.getIdUser());
            stmt.setString(2, value.getEmail());
            stmt.setString(3, value.getUsername());
            stmt.setString(4, value.getPassHash());
            stmt.setString(5, value.getPassSalt());
            stmt.setInt(6, value.getRoleId());

            result = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

      return result;
    }
}
