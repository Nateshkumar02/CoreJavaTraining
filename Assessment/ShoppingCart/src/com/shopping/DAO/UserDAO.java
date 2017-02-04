/**
 * Created by nateshkumar on 2/2/17.
 */
package com.shopping.DAO;
import com.shopping.domain.*;
import java.sql.SQLException;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface UserDAO
{
    public void createUser(File f1) throws FileNotFoundException, IOException, SQLException;
    public void deleteUser(int id) throws SQLException;
    public void updateUser(int id) throws SQLException;
    public List<User> getAllUsers() throws SQLException;
    public User getUserById(int id) throws SQLException;
}
