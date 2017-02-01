package com.java.training;
import java.util.ArrayList;
import java.util.List;
public class Employee {
    int EmployeeId;
    String EmployeeName;
    private int EmployeeAge;
    List<Address> addresses;

    public Employee(int EmployeeId, String EmployeeName, int age) {
        this.EmployeeId= EmployeeId;
        this.EmployeeName = EmployeeName;
        this.EmployeeAge = EmployeeAge;
    }
    public Employee(){
        addresses = new ArrayList<>();
    };

    public int getEmployeeId() {
        return EmployeeId;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public int getEmployeeAge() {
        return EmployeeAge;
    }

    public void setEmployeeAge(int EmployeeAge) {
        if(EmployeeAge>0){
            this.EmployeeAge = EmployeeAge;
        }

    }
    public void addAddress(Address address){
        this.addresses.add(address);
    }
    public static Employee createEmployee(int EmployeeId, String EmployeeName, int age){
        Employee emp = new Employee();
        emp.EmployeeId=EmployeeId;
        emp.EmployeeName=EmployeeName;
        emp.setEmployeeAge(age);
        return emp;
    }
}
