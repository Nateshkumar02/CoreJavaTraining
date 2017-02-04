package com.shopping.client;

import com.shopping.domain.OrderDetail;
import com.shopping.service.OrderDetailServiceimpl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nateshkumar on 2/4/17.
 */
public class OrderDetailClient {

    static OrderDetailServiceimpl orderDetailServiceimpl;

    static{
        orderDetailServiceimpl=new OrderDetailServiceimpl();
    }

    public static void main(String[] args) throws IOException, SQLException {


        OrderDetailClient od = new OrderDetailClient();
        File fp1 = new File("/Users/nateshkumar/Documents/CoreJavaTraining/Assessment/ShoppingCart/src/com/shopping/orderdetailData");
        od.orderDetailServiceimpl.orderDetailcreate(fp1);
        od.orderDetailServiceimpl.orderDetaildelete(3);
        od.orderDetailServiceimpl.orderDetailupdate(4);
        List<OrderDetail> orderDetaillist = orderDetailServiceimpl.orderDetailall(3);
        for (OrderDetail ord : orderDetaillist)
        {
            System.out.println(ord.getId() + ord.getOrderId() + ord.getProductId() + ord.getQuantity() + ord.getPrice() + ord.getAmount());
        }


        List<OrderDetail> orderDetails = new ArrayList<>();
        orderDetails = orderDetailServiceimpl.orderDetailall(1);

        File f1 = new File("//Users/nateshkumar/Documents/CoreJavaTraining/Assessment/ShoppingCart/Amount_Details.csv");
        final String cs = ",";
        final String nls = "\n";

        final String fh = "Order_Id ,Order_Details_Id,Product_Id ,Quantity ,Price ,Amount ";
        FileWriter fw = null;
        try {

            try {
                f1.createNewFile();
                fw = new FileWriter(f1);
                fw.append(fh.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

            double Total = 0.0;
            for (OrderDetail o : orderDetails) {
                double sum = 0;
                try {

                    fw.append(nls);
                    fw.append(Integer.toString(o.getOrderId()));
                    fw.append(cs);
                    fw.append(Integer.toString(o.getId()));
                    fw.append(cs);
                    fw.append(Integer.toString(o.getProductId()));
                    fw.append(cs);
                    fw.append(Integer.toString(o.getQuantity()));
                    fw.append(cs);
                    fw.append(Double.toString(o.getPrice()));
                    fw.append(cs);


                    Double x = o.getPrice();
                    int q = o.getQuantity();
                    sum = sum + (q * x);


                    fw.append(Double.toString(sum));


                    fw.flush();
                    System.out.print(" Amount-> " + o.getAmount());
                    System.out.print(" Order Detail ID-> " + o.getId());
                    System.out.print(" Price-> " + o.getPrice());
                    System.out.print(" Quantity-> " + o.getQuantity());
                    System.out.print(" Product_id -> " + o.getProductId());
                    System.out.print(" Order Id -> " + o.getOrderId());
                    System.out.println(" ");

                    Total = Total + sum;

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
            try {
                fw.append(nls);
                fw.append(cs);
                fw.append(cs);
                fw.append(cs);
                fw.append(cs);
                fw.append("Total Amount=");
                fw.append(cs);
                fw.append(Double.toString(Total));

            } catch (IOException e) {
                e.printStackTrace();
            }


        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
