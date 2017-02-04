package com.shopping.service;
import java.io.IOException;
import com.shopping.domain.User;
import java.io.File;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by nateshkumar on 2/2/17.
 */
public interface UserService {


    public void createUser(File f) throws IOException, SQLException;
    public void deleteUser(int id) throws SQLException;
    public void updateUser(int id) throws SQLException;
    public List<User> getAllUsers() throws SQLException;
    public User getUserById(int id) throws SQLException;
}
