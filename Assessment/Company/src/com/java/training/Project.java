package com.java.training;
import java.util.ArrayList;
import java.util.List;
public class Project {
    int ProjectId;
    String ProjectName;
    List<Employee> Employees;
    public Project(){
        Employees = new ArrayList<>();
    }

    public int getProjectId() {
        return ProjectId;
    }

    public void setProjectId(int ProjectId) {
        this.ProjectId = ProjectId;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String ProjectName) {
        this.ProjectName = ProjectName;
    }

    public List<Employee> getEmployees() {
        return Employees;
    }

    public void setEmployees(List<Employee> employees) {
        Employees = employees;
    }
    public void addEmployee(Employee emp){
        Employees.add(emp);
    }
    public static Project createProject(int ProjectId, String ProjectName){
        Project project =new Project();
        project.setProjectId(ProjectId);
        project.setProjectName(ProjectName);
        return project;
    }
}
