package com.shopping.client;


import com.shopping.domain.Order;
import com.shopping.service.OrderServiceimpl;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by nateshkumar on 2/4/17.
 */
public class OrderClient {

    static OrderServiceimpl orderServiceimpl;

    static
    {
        orderServiceimpl=new OrderServiceimpl();
    }

    public static void main(String[] args) throws IOException, SQLException {

        OrderClient o= new OrderClient();
        File fp3 = new File("/Users/nateshkumar/Documents/CoreJavaTraining/Assessment/ShoppingCart/src/com/shopping/orderData");

        o.orderServiceimpl.ordercreate(fp3);
        o.orderServiceimpl.orderdelete(3);
        o.orderServiceimpl.orderupdate(5);
        //  p.productService.updateproduct(2,"mobile","#ua2", new BigDecimal(150.50),15);
        List<Order> orderList = orderServiceimpl.orderall();
        for (Order ord : orderList
                ) {
            System.out.println(ord.getId() + (ord.getOrderDate().toString()) + ord.getAmount() + ord.getUserId() );
        }


    }
}
