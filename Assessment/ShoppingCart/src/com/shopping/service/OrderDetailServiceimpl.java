/**
 * Created by nateshkumar on 2/2/17.
 */
package com.shopping.service;
import com.shopping.DAO.OrderDetailDAO;
import com.shopping.DAO.OrderDetailDAOimpl;
import com.shopping.domain.OrderDetail;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailServiceimpl implements OrderDetailService
{
    static OrderDetailDAOimpl detailDAOimpl;
    static
    {
         detailDAOimpl= new OrderDetailDAOimpl();
    }
    @Override
    public void orderDetailcreate(File ord3) throws FileNotFoundException, IOException, SQLException
    {
        try
        {
            detailDAOimpl.orderDetailcreate(ord3);
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
    public void orderDetaildelete(int id) throws SQLException
    {
        detailDAOimpl.orderDetaildelete(id);
    }

    @Override
    public void orderDetailupdate(int id) throws SQLException
    {
       detailDAOimpl.orderDetailupdate(id);
    }

    @Override
    public List<OrderDetail> orderDetailall(int id)
    {
        List<OrderDetail> orderDetailList = null;
        try
        {
            orderDetailList = detailDAOimpl.orderDetailall(id);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return orderDetailList;
    }

    @Override
    public List<OrderDetail> orderDetailbyid(int id) throws SQLException
    {
        OrderDetail od1 = detailDAOimpl.orderDetailbyid(id);
        return (List<OrderDetail>) od1;

    }
}
