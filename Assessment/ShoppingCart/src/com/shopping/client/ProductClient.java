package com.shopping.client;

import com.shopping.domain.*;

import com.shopping.service.*;


import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by nateshkumar on 2/4/17.
 */
public class ProductClient {

    static ProductServiceimpl productServiceimpl;

    static
    {
        productServiceimpl = new ProductServiceimpl();
    }

    public static void main(String[] args) throws IOException, SQLException{


    ProductClient p=new ProductClient();
    File fp = new File("/Users/nateshkumar/Documents/CoreJavaTraining/Assessment/ShoppingCart/src/com/shopping/productData");
    p.productServiceimpl.createProduct(fp);
        p.productServiceimpl.deleteProduct(3);
        p.productServiceimpl.updateProduct(5);
    //  p.productService.updateproduct(2,"mobile","#ua2", new BigDecimal(150.50),15);
    List<Product> productList = productServiceimpl.getAllProducts();
        for(Product prod : productList)
        {
        System.out.println(prod.getId() + prod.getName() + prod.getCode() + prod.getPrice() + prod.getStock());
    }


    }
}
