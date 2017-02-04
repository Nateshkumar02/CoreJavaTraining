/**
 * Created by nateshkumar on 2/2/17.
 */
package com.shopping.DAO;
import com.shopping.domain.OrderDetail;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public interface OrderDetailDAO
{
    public void orderDetailcreate(File ord3) throws FileNotFoundException, IOException, SQLException;
    public void orderDetaildelete(int id) throws SQLException;
    public void orderDetailupdate(int id) throws SQLException;
    public List<OrderDetail> orderDetailall(int id) throws SQLException;
    public OrderDetail orderDetailbyid(int id) throws SQLException;

}
