/**
 * Created by nateshkumar on 2/2/17.
 */
package com.shopping.domain;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order
{
        private int id;
        private Date orderDate;
        private double amount;
        private int userId;
        private List<OrderDetail> listOfOrderDetails;

        public int getId() {return id;}

        public void setId(int id) {
            this.id = id;
        }

        public Date getOrderDate() {
            return orderDate;
        }

        public void setOrderDate(Date orderDate) {
            this.orderDate = orderDate;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public List<OrderDetail> getListOfOrderDetails() {
            return listOfOrderDetails;
        }

        public void setListOfOrderDetails(List<OrderDetail> listOfOrderDetails)
        {
            this.listOfOrderDetails = listOfOrderDetails;
        }
    }
