/**
 * Created by nateshkumar on 2/2/17.
 */
package com.shopping.service;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.shopping.DAO.*;
import com.shopping.domain.*;

public class ProductServiceimpl implements ProductService
{

    static ProductDAO productDao;
    static
    {
        productDao = new ProductDAOimpl();

    }

    @Override
    public void createProduct(File f) throws IOException, SQLException
    {
        try
        {
            productDao.createProduct(f);
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
    public void deleteProduct(int id) throws SQLException {
        productDao.deleteProduct(id);
    }

    @Override
    public void updateProduct(int id) throws SQLException {
        productDao.updateProduct(id);
    }

    @Override
    public List<Product> getAllProducts() throws SQLException {
        List<Product> productList = productDao.getAllProducts();
        return productList;
    }

    @Override
    public Product getProductById(int id) throws SQLException {
        return null;
    }
}
