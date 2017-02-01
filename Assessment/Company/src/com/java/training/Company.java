package com.java.training;
import java.util.ArrayList;
import java.util.List;
public class Company {
    int CompanyId;
    String CompanyName;
    List<Department> Departments;
    public Company(){
        Departments=new ArrayList<Department>();
    }

    public int getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(int id) {
        this.CompanyId = id;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String name) {
        this.CompanyName = name;
    }

    public List<Department> getDepartments() {
        return Departments;
    }

    private void setDepartments(List<Department> departments) {
        Departments = departments;
    }
    public void addDepartment(Department department){
        Departments.add(department);
    }
    public static Company createInstance(int CompanyId, String CompanyName){
        Company company = new Company();
        company.setCompanyId(CompanyId);
        company.setCompanyName(CompanyName);
        return company;
    }
}
