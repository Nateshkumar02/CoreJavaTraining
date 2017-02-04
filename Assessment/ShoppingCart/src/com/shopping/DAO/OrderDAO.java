/**
 * Created by nateshkumar on 2/2/17.
 */
package com.shopping.DAO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.shopping.domain.Order;

public interface OrderDAO
{
    public void ordercreate(File ord2) throws FileNotFoundException, IOException, SQLException;
    public void orderdelete(int id) throws SQLException;
    public void orderupdate(int id) throws SQLException;
    public List<Order> orderall() throws SQLException;
    public Order orderbyid(int id) throws SQLException;
}
