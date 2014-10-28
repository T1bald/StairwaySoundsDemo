package com.stairways.dao;

import com.stairways.dao.DAOFactory.MySqlDAOFactory;
import com.stairways.model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public Users getById(int id) {
    Users user = null;

    try {
        PreparedStatement prst = connection.prepareStatement("Select * from users WHERE id_user = ?");
        prst.setInt(1, id);
        ResultSet rs = prst.executeQuery();
        user = new Users();

        while (rs.next()) {

            user.setIdUser(rs.getInt("id_user"));
            user.setEmail(rs.getString("email"));
            user.setUsername(rs.getString("username"));
            user.setPassHash(rs.getString("pass_hash"));
            user.setPassSalt(rs.getString("pass_salt"));
            user.setRoleId(rs.getInt("role_id"));


        }
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

        preparedStatement.setInt(1, value.getIdUser());
        preparedStatement.setString(2, value.getEmail());
        preparedStatement.setString(3, value.getUsername());
        preparedStatement.setString(4, value.getPassHash());
        preparedStatement.setString(5, value.getPassSalt());
        preparedStatement.setInt(6, value.getRoleId());

        int result = preparedStatement.executeUpdate();

        if (result == 1)
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

        preparedStatement.setInt(1, value.getIdUser());
        preparedStatement.setString(2, value.getEmail());
        preparedStatement.setString(3, value.getUsername());
        preparedStatement.setString(4, value.getPassHash());
        preparedStatement.setString(5, value.getPassSalt());
        preparedStatement.setInt(6, value.getRoleId());

        int result = preparedStatement.executeUpdate();

        if (result == 1)
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

        while (rs.next()) {
            user = new Users();

            user.setIdUser(rs.getInt("id_user"));
            user.setEmail(rs.getString("email"));
            user.setUsername(rs.getString("username"));
            user.setPassHash(rs.getString("pass_hash"));
            user.setPassSalt(rs.getString("pass_salt"));
            user.setRoleId(rs.getInt("role_id"));
        }

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

        while (rs.next()) {
            user = new Users();

            user.setIdUser(rs.getInt("id_user"));
            user.setEmail(rs.getString("email"));
            user.setUsername(rs.getString("username"));
            user.setPassHash(rs.getString("pass_hash"));
            user.setPassSalt(rs.getString("pass_salt"));
            user.setRoleId(rs.getInt("role_id"));
        }

    } catch (Exception ex) {
        ex.printStackTrace();
        return null;
    }

    return user;

}
}
