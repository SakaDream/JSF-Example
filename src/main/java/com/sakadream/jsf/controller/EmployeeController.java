package com.sakadream.jsf.controller;

import com.sakadream.jsf.bean.Employee;
import com.sakadream.jsf.func.Functions;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Phan Ba Hai on 18/07/2017.
 */

@ManagedBean(name = "emp", eager = true)
@RequestScoped
public class EmployeeController implements Serializable {

    private Functions func = new Functions();

    public List<Employee> showAllEmployees() throws SQLException, ClassNotFoundException {
        return func.showAllEmployees();
    }

    public Employee getEmployee() throws SQLException, ClassNotFoundException {
        String idStr = func.getParameterByName("id");
        int id;
        try {
            id = Integer.valueOf(idStr);
        } catch (NumberFormatException e) {
            id = 0;
        }
        return func.getEmployeeById(id);
    }

    public String addEmployee() throws SQLException, ClassNotFoundException {
        String fullName = func.getParameterByName("fullName");
        String address = func.getParameterByName("address");
        String email = func.getParameterByName("email");
        String phone = func.getParameterByName("phone");
        String salaryStr = func.getParameterByName("salary");
        int salary = Integer.valueOf(salaryStr);

        func.addEmployee(fullName, address, email, phone, salary);
        return "home";
    }

    public void editEmployee() throws SQLException, ClassNotFoundException, IOException {
        String idStr = func.getParameterByName("editForm:id");
        int id = Integer.valueOf(idStr);
        String fullName = func.getParameterByName("fullName");
        String address = func.getParameterByName("address");
        String email = func.getParameterByName("email");
        String phone = func.getParameterByName("phone");
        String salaryStr = func.getParameterByName("salary");
        int salary = Integer.valueOf(salaryStr);

        func.editEmloyee(id, fullName, address, email, phone, salary);

        FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml"); //Redirect to home.xhtml
    }

    public String deleteEmployee(String idStr) throws SQLException, ClassNotFoundException {
        int id = Integer.valueOf(idStr);

        func.deleteEmployee(id);
        return "home";
    }
}
