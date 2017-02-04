/**
 * Created by nateshkumar on 2/2/17.
 */
package com.shopping.DAO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import com.shopping.domain.*;

public interface ProductDAO
{
    public void createProduct(File f) throws IOException, SQLException;
    public void deleteProduct(int id) throws SQLException;
    public void updateProduct(int id) throws SQLException;
    public List<Product> getAllProducts() throws SQLException;
    public Product getProductById(int id) throws SQLException;
}
