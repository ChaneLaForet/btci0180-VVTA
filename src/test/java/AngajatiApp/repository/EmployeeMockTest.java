package AngajatiApp.repository;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;
import AngajatiApp.validator.EmployeeValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMockTest {

    private EmployeeMock employeeMock;

    @BeforeEach
    void setUp() {
        employeeMock = new EmployeeMock();

//        for (Employee e : employeeMock.getEmployeeList()){          //shows all the employees
//            System.out.println("employee: " + e);
//        }
//        int employeeNr = employeeMock.getEmployeeList().size();     //shows the number of employees
//        System.out.println(employeeNr);
    }

//    @AfterEach
//    void showEmployees() {
//        for (Employee e : employeeMock.getEmployeeList()) {
//            System.out.println("employee: " + e);
//        }
//    }
    
    @Test
    void addEmployee_TC1_BB() {     //firstName incepe cu litera mica
        Employee testEmployee = new Employee();
        testEmployee.setFirstName("mary");
        testEmployee.setLastName("Westbrook");
        testEmployee.setCnp("1234567890123");
        testEmployee.setSalary(3000.0);
        testEmployee.setFunction(DidacticFunction.LECTURER);

        //dar in cod nu exista astfel de validare, numai ca numele sa fie format din minim 2 litere
        //EmployeeValidator ->  isFirstNameValid (linia 41)
        assertFalse(employeeMock.addEmployee(testEmployee));
    }

    @Test
    void addEmployee_TC2_BB() {     //cnp contine si o litera
        Employee testEmployee = new Employee();
        testEmployee.setFirstName("Mary");
        testEmployee.setLastName("Westbrook");
        testEmployee.setCnp("a234567890123");
        testEmployee.setSalary(3000.0);
        testEmployee.setFunction(DidacticFunction.LECTURER);

        assertFalse(employeeMock.addEmployee(testEmployee));

        try {
            int employeeNr = employeeMock.getEmployeeList().size();
            try {
                employeeMock.addEmployee(testEmployee);
                assertEquals(employeeNr, employeeMock.getEmployeeList().size());
                System.out.println("TC2_BB: Employee was not added.");
            } catch (Exception e) {
                e.printStackTrace();
                assert (false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void addEmployee_TC3_BB() {     //cnp contine 12 cifre
        Employee testEmployee = new Employee();
        testEmployee.setFirstName("Mary");
        testEmployee.setLastName("Westbrook");
        testEmployee.setCnp("a23456789012");
        testEmployee.setSalary(3000.0);
        testEmployee.setFunction(DidacticFunction.LECTURER);

        assertFalse(employeeMock.addEmployee(testEmployee));
    }

    @Test
    void addEmployee_TC4_BB() {     //valori corecte
        Employee testEmployee = new Employee();
        testEmployee.setFirstName("Mary");
        testEmployee.setLastName("Westbrook");
        testEmployee.setCnp("1234567890123");
        testEmployee.setSalary(3000.0);
        testEmployee.setFunction(DidacticFunction.LECTURER);

        try {
            int employeeNr = employeeMock.getEmployeeList().size();
            try {
                employeeMock.addEmployee(testEmployee);
                assertEquals(employeeNr + 1, employeeMock.getEmployeeList().size());
                System.out.println("TC4_BB: Employee was added successfully.");
            } catch (Exception e) {
                e.printStackTrace();
                assert (false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void addEmployee_TC5_BB() {     //cnp contine 14 cifre
        Employee testEmployee = new Employee();
        testEmployee.setFirstName("Mary");
        testEmployee.setLastName("Westbrook");
        testEmployee.setCnp("a2345678901234");
        testEmployee.setSalary(3000.0);
        testEmployee.setFunction(DidacticFunction.LECTURER);

        assertFalse(employeeMock.addEmployee(testEmployee));
    }

    @Test
    void addEmployee_TC6_BB() {     //firstName contine caracter special
        Employee testEmployee = new Employee();
        testEmployee.setFirstName("@ary");
        testEmployee.setLastName("Westbrook");
        testEmployee.setCnp("a2345678901234");
        testEmployee.setSalary(3000.0);
        testEmployee.setFunction(DidacticFunction.LECTURER);

        assertFalse(employeeMock.addEmployee(testEmployee));
    }

    @Test
    void addEmployee_TC7_BB() {     //firstName incepe cu A
        Employee testEmployee = new Employee();
        testEmployee.setFirstName("Anne");
        testEmployee.setLastName("Westbrook");
        testEmployee.setCnp("1234567890123");
        testEmployee.setSalary(3000.0);
        testEmployee.setFunction(DidacticFunction.LECTURER);

        //assertTrue(employeeMock.addEmployee(testEmployee));

        try {
            int employeeNr = employeeMock.getEmployeeList().size();
            try {
                employeeMock.addEmployee(testEmployee);
                assertEquals(employeeNr + 1, employeeMock.getEmployeeList().size());
                assertTrue(employeeMock.addEmployee(testEmployee));
                System.out.println("TC7_BB: Employee was added successfully.");
            } catch (Exception e) {
                e.printStackTrace();
                assert (false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void addEmployee_TC8_BB() {     //firstName incepe cu Z
        Employee testEmployee = new Employee();
        testEmployee.setFirstName("Zendaya");
        testEmployee.setLastName("Westbrook");
        testEmployee.setCnp("1234567890123");
        testEmployee.setSalary(3000.0);
        testEmployee.setFunction(DidacticFunction.LECTURER);

        //assertTrue(employeeMock.addEmployee(testEmployee));

        try {
            int employeeNr = employeeMock.getEmployeeList().size();
            try {
                employeeMock.addEmployee(testEmployee);
                assertEquals(employeeNr + 1, employeeMock.getEmployeeList().size());
                assertTrue(employeeMock.addEmployee(testEmployee));
                System.out.println("TC8_BB: Employee was added successfully.");
            } catch (Exception e) {
                e.printStackTrace();
                assert (false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void addEmployee_TC9_BB() {     //firstName incepe cu [
        Employee testEmployee = new Employee();
        testEmployee.setFirstName("[ary");
        testEmployee.setLastName("Westbrook");
        testEmployee.setCnp("a2345678901234");
        testEmployee.setSalary(3000.0);
        testEmployee.setFunction(DidacticFunction.LECTURER);

        assertFalse(employeeMock.addEmployee(testEmployee));
    }
}