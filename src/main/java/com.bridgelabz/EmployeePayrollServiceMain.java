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

import com.bridgelabz.exception.EmployeePayrollValidation;
import com.bridgelabz.model.EmployeePayrollData;
import com.bridgelabz.service.EmployeePayrollDBService;

import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollServiceMain {
    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

    public EmployeePayrollServiceMain() {
    }

    public EmployeePayrollServiceMain(List<EmployeePayrollData> employeePayrollList) {
        this.employeePayrollList = employeePayrollList;
    }

    /**
     * Main Method or Starting point of this program.
     *
     * @param args
     */
    public static void main(String[] args) throws EmployeePayrollValidation{
        EmployeePayrollDBService employeePayrollDBService = new EmployeePayrollDBService();
        employeePayrollDBService.getConnection();
    }

}
