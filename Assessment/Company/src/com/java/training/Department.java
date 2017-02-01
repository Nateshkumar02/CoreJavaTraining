package com.java.training;
import java.util.ArrayList;
import java.util.List;

public class Department {
    int DepartmentId;
    String DepartmentName;
    List<Project> projects;
    public Department(){
        projects = new ArrayList<Project>();
    }
    public int getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(int DepartmentId) {
        this.DepartmentId = DepartmentId;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String DepartmentName) {
        this.DepartmentName = DepartmentName;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        projects = projects;
    }
    public void addProjects(Project project){
        projects.add(project);
    }
    public static Department createDepartment(int DepartmentId, String DepartmentName){
        Department dep = new Department();
        dep.setDepartmentId(DepartmentId);
        dep.setDepartmentName(DepartmentName);
        return dep;
    }

}
