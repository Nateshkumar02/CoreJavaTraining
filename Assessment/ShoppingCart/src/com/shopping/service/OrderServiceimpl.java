/**
 * Created by nateshkumar on 2/2/17.
 */
package com.shopping.service;
import com.shopping.DAO.OrderDAO;
import com.shopping.DAO.OrderDAOimpl;
import com.shopping.domain.Order;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class OrderServiceimpl implements OrderService
{
    static OrderDAO orderDAO;
    static
    {
        orderDAO = new OrderDAOimpl();
    }
    @Override
    public void ordercreate(File ord2) throws FileNotFoundException, IOException, SQLException
    {
        try
        {
            orderDAO.ordercreate(ord2);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void orderdelete(int id) throws SQLException {
        orderDAO.orderdelete(id);
    }

    @Override
    public void orderupdate(int id) throws SQLException {
        orderDAO.orderupdate(id);
    }

    @Override
    public List<Order> orderall() throws SQLException {
        List<Order> orderList = orderDAO.orderall();
        return orderList;
    }

    @Override
    public Order orderbyid(int id) throws SQLException {
        Order od1 = orderDAO.orderbyid(id);
        return od1;
    }

    @Override
    public List<Order> orderDetailall(int i)
    {
        List<Order> orderList = null;
        try
        {
            orderList = orderDAO.orderall();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return orderList;
    }
}
