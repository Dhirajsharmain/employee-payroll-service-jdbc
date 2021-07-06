package com.bridgelabz;
import com.bridgelabz.exception.EmployeePayrollException;
import com.bridgelabz.model.EmployeePayrollData;
import com.bridgelabz.service.EmployeePayrollDBService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class EmployeePayrollServiceTest {

    EmployeePayrollDBService employeePayrollDBService;

    @Before
    public void setup() {
        employeePayrollDBService = new EmployeePayrollDBService();;
    }

    @Test
    public void givenEmployeeInDB_whenRetrieved_shouldMatchEmployeeCount() throws EmployeePayrollException {
        List<EmployeePayrollData> employeePayrollList = employeePayrollDBService.readData();
        Assert.assertEquals(4,employeePayrollList.size());
    }
}
