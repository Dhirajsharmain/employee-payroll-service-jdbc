/**
 * ****************************************************************************
 * Purpose: The purpose of this class learn to use JDBC API to connect to DB and
 * execute SQL Queries with the DB, Learning Problem of Employee Payroll Problem.
 *
 * @author Dhiraj
 * @version 1.0
 * @since 06-06-2021
 * ****************************************************************************
 */
package com.bridgelabz;

import com.bridgelabz.exception.EmployeePayrollException;
import com.bridgelabz.model.EmployeePayrollData;
import com.bridgelabz.service.EmployeePayrollDBService;

import java.sql.SQLException;
import java.util.List;

public class EmployeePayrollServiceMain {

    private List<EmployeePayrollData> employeePayrollList;

    private EmployeePayrollDBService employeePayrollDBService;

    public List<EmployeePayrollData> getEmployeePayrollList() {
        return employeePayrollList;
    }

    public EmployeePayrollServiceMain(){
        employeePayrollDBService = EmployeePayrollDBService.getInstance();
    }

    public EmployeePayrollServiceMain(List<EmployeePayrollData> employeePayrollList){
        this();
        this.employeePayrollList = employeePayrollList;
    }
    /**
     * Main Method or Starting point of this program.
     *
     * @param args
     */
    public static void main(String[] args) throws EmployeePayrollException {
//        EmployeePayrollDBService employeePayrollDBService = new EmployeePayrollDBService();
//        employeePayrollDBService.getConnection();
//        employeePayrollDBService.readData();
    }

    public List<EmployeePayrollData> retrievingEmployeeData() throws EmployeePayrollException {
        this.employeePayrollList = employeePayrollDBService.readData();
        return this.employeePayrollList;
    }

    public void updateEmployeeSalary(String name, double salary) throws SQLException, EmployeePayrollException {
        int result = employeePayrollDBService.updateData(name,salary);
        if ( result == 0 ) return;
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollData(name);
        if (employeePayrollData != null) employeePayrollData.setSalary(salary);
    }

    private EmployeePayrollData getEmployeePayrollData(String name) {
        EmployeePayrollData employeePayrollData;
        employeePayrollData = this.employeePayrollList.stream()
                .filter(employeePayrollDataItem -> employeePayrollDataItem.getName().equals(name))
                .findFirst()
                .orElse(null);
        return employeePayrollData;
    }

    public boolean checkEmployeePayrollInSyncWithDB(String name) {
        List<EmployeePayrollData> employeePayrollDataList = employeePayrollDBService.getEmployeeData(name);
        return employeePayrollDataList.get(0).equals(getEmployeePayrollData(name));
    }
}
