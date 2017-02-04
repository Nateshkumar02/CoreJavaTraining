/**
 * Created by nateshkumar on 2/2/17.
 */
package com.shopping.DAO;
import com.shopping.domain.OrderDetail;
import com.shopping.utils.DBConnection;
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
import java.util.List;


public class OrderDetailDAOimpl implements OrderDetailDAO
{
    @Override
    public void orderDetailcreate(File ord3) throws FileNotFoundException, IOException, SQLException
    {
        Connection con = DBConnection.getConnection();
        BigDecimal k;
        PreparedStatement ps=null;
        File f=ord3;
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
            ps = con.prepareStatement("Insert into order_detail (order_id,product_id,quantity,price,amount) VALUES (?,?,?,?,?);");
            ps.setString(1,entry[0]);
            ps.setString(2,entry[1]);
            ps.setString(3,entry[2]);
            ps.setString(4,entry[3]);
            ps.setString(5,entry[4]);
            ps.executeUpdate();
        }
        con.close();
    }

    @Override
    public void orderDetaildelete(int id) throws SQLException
    {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = null;
        ps=con.prepareStatement("delete from order_detail where orderdetail_id = ?");
        ps.setInt(1,id);
        ps.executeUpdate();
        con.close();

    }

    @Override
    public void orderDetailupdate(int id) throws SQLException
    {

        Connection con = DBConnection.getConnection();
        PreparedStatement ps=null;
        ps=con.prepareStatement("update order_detail SET order_id=? , product_id=? , quantity=? , price=? ,amount=? where orderdetail_id=?;");
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
    public List<OrderDetail> orderDetailall(int id) throws SQLException
    {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps=null;
        ResultSet rs = null;
        List<OrderDetail> orderdetailList = new ArrayList<>();
        ps= con.prepareStatement("Select * from order_detail");
        rs=ps.executeQuery();
        while(rs.next())
        {
            OrderDetail orderDetail = new OrderDetail();
            int id1 = rs.getInt("orderdetail_id");
            int orderId = rs.getInt("order_id");
            int productId = rs.getInt("product_id");
            int quantity = rs.getInt("quantity");
            double price = rs.getInt("price");
            double amount = rs.getInt("amount");
            orderDetail.setId(id1);
            orderDetail.setOrderId(orderId);
            orderDetail.setProductId(productId);
            orderDetail.setQuantity(quantity);
            orderDetail.setPrice(price);
            orderDetail.setAmount(amount);
            orderdetailList.add(orderDetail);
        }
        con.close();
        return orderdetailList;
    }

    @Override
    public OrderDetail orderDetailbyid(int id1) throws SQLException
    {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ps = con.prepareStatement("select * from order_detail where orderdetail_id=?");
        ps.setInt(1,id1);
        rs = ps.executeQuery();
        OrderDetail orderDetails = new OrderDetail();
        rs.next();
        int id = rs.getInt("orderdetail_id");
        int orderId = rs.getInt("order_id");
        int productId = rs.getInt("product_id");
        int quantity = rs.getInt("quantity");
        double price = rs.getInt("price");
        double amount = rs.getInt("amount");
        orderDetails.setId(id);
        orderDetails.setOrderId(orderId);
        orderDetails.setProductId(productId);
        orderDetails.setQuantity(quantity);
        orderDetails.setPrice(price);
        orderDetails.setAmount(amount);
        con.close();
        return orderDetails;
    }
}
