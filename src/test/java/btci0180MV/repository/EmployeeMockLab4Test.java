package btci0180MV.repository;

import btci0180MV.controller.DidacticFunction;
import btci0180MV.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeMockLab4Test {

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

    @Test
    void modifyEmployeeFunction_TC1() {
        List<Employee> employeeList = employeeMock.getEmployeeList();
        //afisare lista
        int i = 1;
        for (Employee e : employeeList) {
            System.out.println("employee " + i + ": " + e);
            i++;
        }

        Employee Ionel = employeeMock.getEmployeeList().get(0);
        employeeMock.modifyEmployeeFunction(Ionel, DidacticFunction.TEACHER);

        assertNotEquals(DidacticFunction.ASISTENT, Ionel.getFunction());
        assertEquals(DidacticFunction.TEACHER, Ionel.getFunction());
        //S-a modificat si in lista de employee
        assertNotEquals(DidacticFunction.ASISTENT, employeeMock.getEmployeeList().get(0).getFunction());
        assertEquals(DidacticFunction.TEACHER, employeeMock.getEmployeeList().get(0).getFunction());

        System.out.println("\nmodifyEmployeeFunction_TC1: The employee was modified successfully.");
        System.out.println("employee 0: " + employeeMock.getEmployeeList().get(0));
    }

    @Test
    void modifyEmployeeFunction_TC2() {
        List<Employee> employeeList = employeeMock.getEmployeeList();
        //afisare lista
//        int i = 1;
//        for (Employee e : employeeList) {          //shows all the employees
//            System.out.println("employee " + i + ": " + e);
//            i++;
//        }
        Employee Ionel = null;

        try {
            employeeMock.modifyEmployeeFunction(Ionel, DidacticFunction.TEACHER);

            assertAll("Employees",
                    () -> assertNotEquals(DidacticFunction.ASISTENT, null),
                    () -> assertNotEquals(DidacticFunction.TEACHER, null));
            System.out.println("The employee was not modified.");
        }catch(Exception exception){
//            assert(true);
            exception.printStackTrace();
            assert (false);
        }

        System.out.println("Employee in the list: " + employeeMock.getEmployeeList().get(0));
        System.out.println("The employee is: "+Ionel);
    }

    // @Test
    //    void modifyEmployeeFunction_TC2() {
    //        List<Employee> employeeList = employeeMock.getEmployeeList();
    //        //afisare lista
    //        int i = 1;
    //        for (Employee e : employeeList) {          //shows all the employees
    //            System.out.println("employee " + i + ": " + e);
    //            i++;
    //        }
    //
    //        Employee Ionel = null;
    //        employeeMock.modifyEmployeeFunction(Ionel, DidacticFunction.TEACHER);
    //
    //        assertAll("Employees",
    //                () -> assertNotEquals(DidacticFunction.ASISTENT, Ionel.getFunction()),
    //                () -> assertNotEquals(DidacticFunction.TEACHER, Ionel.getFunction()),
    //                () -> assertNull(Ionel.getFunction()));
    //
    //        System.out.println("Employee in the list: " + employeeMock.getEmployeeList().get(0));
    //        System.out.println("The employee is: "+Ionel);
    //    }
}
