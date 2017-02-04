package com.shopping.DAO;

import com.shopping.domain.User;
import com.shopping.utils.DBConnection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.String;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.*;
import com.shopping.DAO.UserDAO;
import com.shopping.DAO.UserDaoImpl;
import com.shopping.domain.User;

/**
 * Created by nateshkumar on 2/2/17.
 */
public class UserDaoImpl implements UserDAO
{
    @Override
    public void createUser(File f1) throws IOException, SQLException {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps=null;
        File f=f1;
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String s;
        StringBuilder sb = new StringBuilder();
        while((s=br.readLine())!=null){
            sb.append(s).append("\n");
            System.out.println(s);
        }
        s=sb.toString();
        System.out.println(s);
        String[] str = s.split("\n");
        for (String st:str
                ) {
            System.out.println(st);
            String[] entry = st.split(",");
            ps = con.prepareStatement("Insert into user (user_name,first_name,last_name,address) VALUES (?,?,?,?)");
            ps.setString(1, entry[0]);
            System.out.println(entry[0]);
            ps.setString(2, entry[1]);
            ps.setString(3, entry[2]);
            ps.setString(4, entry[3]);
            ps.executeUpdate();
        }
        con.close();
    }

    @Override
    public void deleteUser(int id) throws SQLException
    {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = null;
        ps=con.prepareStatement("delete from user where user_id = ?;");
        ps.setInt(1,id);
        ps.executeUpdate();
        con.close();

    }

    @Override
    public void updateUser(int id) throws SQLException
    {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps=null;
        ps=con.prepareStatement("update user SET user_name=? , first_name=? , last_name=? , address=? where user_id=?;");
        ps.setString(1,"Arsh22");
        ps.setString(2,"Arsh");
        ps.setString(3,"deep");
        ps.setString(4,"Chd");
        ps.setInt(5,5);
        ps.executeUpdate();
        con.close();
    }

    @Override
    public List<User> getAllUsers() throws SQLException
    {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps=null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<>();
        ps= con.prepareStatement("Select * from user");
        rs=ps.executeQuery();
        while(rs.next())
        {
            User user = new User();
            int id = rs.getInt("user_id");
            String userName = rs.getString("user_name");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String address = rs.getString("address");
            user.setId(id);
            user.setUserName(userName);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setAddress(address);
            userList.add(user);
        }
        con.close();
        return userList;
    }

    @Override
    public User getUserById(int id) throws SQLException
    {
        User user = new User();
        Connection con =DBConnection.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        ps=con.prepareStatement("Select * from user where user_id=?");
        ps.setInt(1,id);
        rs=ps.executeQuery();
        rs.next();
        int id1 = rs.getInt("user_id");
        String userName = rs.getString("user_name");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String address = rs.getString("address");
        user.setId(id1);
        user.setUserName(userName);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAddress(address);
        con.close();
        return user;
    }

}

