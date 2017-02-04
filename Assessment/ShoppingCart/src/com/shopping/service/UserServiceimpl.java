package com.shopping.service;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.shopping.DAO.UserDAO;
import com.shopping.DAO.UserDaoImpl;
import com.shopping.domain.User;

import com.shopping.DAO.UserDAO;


public class UserServiceimpl implements UserService {
    static UserDAO userDAO;
    static {
        userDAO = new UserDaoImpl();
    }

    @Override
    public void createUser(File f) throws IOException, SQLException {
        try {
            userDAO.createUser(f);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   @Override
    public void deleteUser(int id) throws SQLException {
        userDAO.deleteUser(id);
    }

    @Override
    public void updateUser(int id) throws SQLException {
        userDAO.updateUser(id);
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        return userDAO.getAllUsers();

    }

    @Override
    public User getUserById(int id) throws SQLException {
        User u = userDAO.getUserById(id);
        return u;
    }

}
