/**
 * Created by nateshkumar on 2/2/17.
 */
package com.shopping.domain;
import java.math.BigDecimal;

public class Product
{
    private int id;
    private String name;
    private String code;
    private BigDecimal price;
    private int stock;

    public Product(int id, String name, String code, BigDecimal price, int stock)
    {
        this.id = id;
        this.name = name;

        this.code = code;
        this.price = price;
        this.stock = stock;
    }
    public Product()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getPrice() { return price; }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
