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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.shopping.domain.*;
import com.shopping.utils.DBConnection;

public class ProductDAOimpl implements ProductDAO
{
    @Override
    public void createProduct(File f1) throws IOException, SQLException
    {
        Connection con = DBConnection.getConnection();
        BigDecimal k;
        PreparedStatement ps=null;
        File f=f1;
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
            ps = con.prepareStatement("Insert into product (name,code,price,stock) VALUES (?,?,?,?)");
            ps.setString(1, entry[0]);
            ps.setString(2, entry[1]);
            k=new BigDecimal(entry[2]);
            ps.setBigDecimal(3,k);
            ps.setInt(4, Integer.parseInt(entry[3]));
            ps.executeUpdate();
        }
        con.close();
    }

    @Override
    public void deleteProduct(int id) throws SQLException
    {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = null;
        ps=con.prepareStatement("delete from product where product_id = ?");
        ps.setInt(1,id);
        ps.executeUpdate();
        con.close();
    }

    @Override
    public void updateProduct(int id) throws SQLException
    {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps=null;
        ps=con.prepareStatement("update product SET name=? , code=? , price=? , stock=? where product_id=?;");
        ps.setString(1,"Coffee Cup");
        ps.setString(2,"c123");
        ps.setFloat(3, 256);
        ps.setInt(4,23);
        ps.setInt(5,2);
        ps.executeUpdate();
        con.close();
    }

    @Override
    public List<Product> getAllProducts() throws SQLException
    {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps=null;
        ResultSet rs = null;
        List<Product> productList = new ArrayList<>();
        ps= con.prepareStatement("Select * from product");
        rs=ps.executeQuery();
        while(rs.next())
        {
            Product product = new Product();
            int id = rs.getInt("product_id");
            String name = rs.getString("name");
            String code = rs.getString("code");
            BigDecimal price = rs.getBigDecimal("price");
            int stock = rs.getInt("stock");
            product.setId(id);
            product.setName(name);
            product.setCode(code);
            product.setPrice(price);
            product.setStock(stock);
            productList.add(product);
        }
        con.close();
        return productList;
    }

    @Override
    public Product getProductById(int id1) throws SQLException
    {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ps = con.prepareStatement("select * from product where product_id=?");
        ps.setInt(1,id1);
        rs = ps.executeQuery();
        Product product = new Product();
        rs.next();
        int id = rs.getInt("product_id");
        String name = rs.getString("name");
        String code = rs.getString("code");
        BigDecimal price = rs.getBigDecimal("price");
        int stock = rs.getInt("stock");
        product.setId(id);
        product.setName(name);
        product.setCode(code);
        product.setPrice(price);
        product.setStock(stock);
        con.close();
        return product;
    }
}
