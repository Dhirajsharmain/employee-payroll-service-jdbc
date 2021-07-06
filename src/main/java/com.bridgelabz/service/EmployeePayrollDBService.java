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
package com.bridgelabz.service;

import com.bridgelabz.exception.EmployeePayrollValidation;

import java.sql.Connection;
import java.sql.DriverManager;

public class EmployeePayrollDBService {

    /**
     * Method for create connection to the database.
     * @return : Connection
     * @throws EmployeePayrollValidation
     */
    public Connection getConnection() throws EmployeePayrollValidation {
        Connection con = null;
        try {
            Class.forName("java.sql.DriverManager");
            System.out.println("Driver loaded");
            String username = "root";
            String password = "root";
            String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
            System.out.println("connecting to database : " + jdbcURL);
            con = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("connection is successfully " + con);
        } catch (Exception e) {
            throw new EmployeePayrollValidation(e.getMessage());
        }
        return con;
    }
}
