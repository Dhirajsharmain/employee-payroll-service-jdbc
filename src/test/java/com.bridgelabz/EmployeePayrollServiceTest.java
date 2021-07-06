package com.bridgelabz;
import com.bridgelabz.exception.EmployeePayrollException;
import com.bridgelabz.model.EmployeePayrollData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class EmployeePayrollServiceTest {

    EmployeePayrollServiceMain employeePayrollServiceMain;

    @Before
    public void setup() {
        employeePayrollServiceMain = new EmployeePayrollServiceMain();
    }

    @Test
    public void givenEmployeeInDB_whenRetrieved_shouldMatchEmployeeCount() throws EmployeePayrollException {
        List<EmployeePayrollData> employeePayrollList = employeePayrollServiceMain.retrievingEmployeeData();
        Assert.assertEquals(4,employeePayrollList.size());
    }

    @Test
    public void givenNewSalaryForEmployee_whenUpdated_shouldSyncWithDB() throws EmployeePayrollException, SQLException {
        EmployeePayrollServiceMain employeePayrollServiceMain = new EmployeePayrollServiceMain();
        List<EmployeePayrollData> employeePayrollList = employeePayrollServiceMain.retrievingEmployeeData();
        employeePayrollServiceMain.updateEmployeeSalary("Terisa", 300000.00);
        boolean result = employeePayrollServiceMain.checkEmployeePayrollInSyncWithDB("Terisa");
        Assert.assertTrue(result);
    }
}
