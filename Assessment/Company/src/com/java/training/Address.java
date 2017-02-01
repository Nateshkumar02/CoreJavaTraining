package com.java.training;

/**
 * Created by nateshkumar on 2/1/17.
 */
public class Address {
    String street;
    String city;
    String state;
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public static Address createAddress(String street, String city, String state){
        Address address = new Address();
        address.setCity(city);
        address.setState(state);
        address.setStreet(street);
        return address;
    }
}
