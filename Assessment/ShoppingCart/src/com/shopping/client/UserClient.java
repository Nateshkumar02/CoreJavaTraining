package com.shopping.client;

import com.shopping.domain.*;
import com.shopping.service.UserServiceimpl;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by nateshkumar on 2/4/17.
 */
public class UserClient {
    static UserServiceimpl userServiceimpl;

    static {
        userServiceimpl = new UserServiceimpl();
    }

    public static void main(String[] args) throws IOException, SQLException {
        UserClient c = new UserClient();
        File fu = new File("/Users/nateshkumar/Documents/CoreJavaTraining/Assessment/ShoppingCart/src/com/shopping/Data");
        c.userServiceimpl.createUser(fu);
        c.userServiceimpl.updateUser(5);
        c.userServiceimpl.deleteUser(3);
        List<User> userList = userServiceimpl.getAllUsers();
        for (User u : userList
                ) {
            System.out.println(u.getId() + "," + u.getUserName() + "," + u.getFirstName() + "," + u.getLastName() + "," + u.getAddress());
        }
        User u = userServiceimpl.getUserById(1);
        System.out.println(u.getId() + "," + u.getUserName() + "," + u.getFirstName() + "," + u.getLastName() + "," + u.getAddress());

    }
}
