/**
 * Created by nateshkumar on 2/2/17.
 */
package com.shopping.DAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.shopping.domain.Order;
import com.shopping.domain.OrderDetail;
import com.shopping.service.OrderDetailServiceimpl;
import com.shopping.utils.DBConnection;


public class OrderDAOimpl implements OrderDAO {

    @Override
    public void ordercreate(File ord2) throws FileNotFoundException, IOException, SQLException
    {
        Connection con = DBConnection.getConnection();
        BigDecimal k;
        PreparedStatement ps=null;
        File f=ord2;
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String s;
        StringBuilder sb = new StringBuilder();
        while((s=br.readLine())!=null)
        {
            sb.append(s).append("\n");
            System.out.println(s);
        }
        s=sb.toString();
        System.out.println(s);
        String[] str = s.split("\n");
        for (String st:str)
        {
            System.out.println(st);
            String[] entry = st.split(",");
            ps = con.prepareStatement("Insert into orders (orderdate,amount,user_id) VALUES (?,?,?)");
            ps.setString(1, entry[0]);
            ps.setString(2, entry[1]);
            ps.setString(3, entry[2]);
            ps.executeUpdate();
        }
        con.close();
    }

    @Override
    public void orderdelete(int id) throws SQLException
    {

        Connection con = DBConnection.getConnection();
        PreparedStatement ps = null;
        ps=con.prepareStatement("delete from orders where order_id = ?");
        ps.setInt(1,id);
        ps.executeUpdate();
        con.close();
    }

    @Override
    public void orderupdate(int id) throws SQLException
    {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps=null;
        ps=con.prepareStatement("update orders SET orderdate=? , amount=? , userId=? where order_id=?;");
        ps.setInt(1,2);
        ps.setInt(2,3);
        ps.setInt(3,3);
        ps.setDouble(4,200);
        ps.setDouble(5,600);
        ps.setInt(6,3);
        ps.executeUpdate();
        con.close();
    }


    @Override
    public List<Order> orderall() throws SQLException
    {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps=null;
        ResultSet rs = null;
        List<Order> orderlist = new ArrayList<>();
        ps= con.prepareStatement("Select * from orders");
        rs=ps.executeQuery();
        while(rs.next())
        {
            Order order = new Order();
            int id = rs.getInt("order_id");
            Date orderDate = rs.getDate("orderdate");
            Double amount = rs.getDouble("amount");
            int userId = rs.getInt("user_id");
            OrderDetailServiceimpl i = new OrderDetailServiceimpl();
            order.setListOfOrderDetails(i.orderDetailall(rs.getInt("order_id")));
            order.setId(id);
            order.setOrderDate(orderDate);
            order.setAmount(amount);
            order.setUserId(userId);
            orderlist.add(order);
        }
        con.close();
        return orderlist;

    }

    @Override
    public Order orderbyid(int id1) throws SQLException
    {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps=null;
        ResultSet rs1 = null;
        List<Order> orderlist = new ArrayList<>();
        ps= con.prepareStatement("Select * from order_detail");
        rs1=ps.executeQuery();
        rs1.next();
        Order order = new Order();
        int id = rs1.getInt("order_id");
        Date orderDate = rs1.getDate("orderdate");
        Double amount = rs1.getDouble("amount");
        int userId = rs1.getInt("user_id");
        OrderDetailServiceimpl o = new OrderDetailServiceimpl();
        List<OrderDetail> od =  o.orderDetailall(rs1.getInt("order_id"));
        order.setListOfOrderDetails(od);
        order.setId(id);
        order.setOrderDate(orderDate);
        order.setAmount(amount);
        order.setUserId(userId);
        con.close();
        return order;
    }

}
