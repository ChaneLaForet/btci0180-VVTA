package AngajatiApp.model;

import AngajatiApp.controller.DidacticFunction;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
//import junit.runner.Version;


import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    Employee e1, e2, e3;

    @BeforeEach
    public void SetUp() {
        e1 = new Employee();
        e2 = null;
        e3 = new Employee("Mary", "Scott", "4321", DidacticFunction.LECTURER, 50.0d);
        System.out.println("Before each.");
    }

    @AfterEach
    public void TearDown() {
        e1 = null;
        e2 = null;
        e3 = null;
        System.out.println("After each.");
    }

    @Order(2)
    @Test
    public void constructor_should_setAllFieldsCorrectly() {                     //a trebuit sa fie public
        Employee newEmployee1 = new Employee();
        Employee newEmployee2 = new Employee("Benjamin", "Pratt", "1234", DidacticFunction.TEACHER, 30.0d);

        assertNull(e2);
        System.out.println("Ok.");
        assertEquals("Mary", e3.getFirstName());

        assertNotEquals(null, newEmployee1);
        assertEquals("", newEmployee1.getFirstName());
        assertEquals("", newEmployee1.getLastName());
        assertEquals("", newEmployee1.getCnp());
        assertEquals(DidacticFunction.ASISTENT, newEmployee1.getFunction());
        assertEquals(0.0d, newEmployee1.getSalary());

        assertNotEquals(null, newEmployee2);
        assertEquals("Benjamin", newEmployee2.getFirstName());
        assertEquals("Pratt", newEmployee2.getLastName());
        assertEquals("1234", newEmployee2.getCnp());
        assertEquals(DidacticFunction.TEACHER, newEmployee2.getFunction());
        assertEquals(30.0d, newEmployee2.getSalary());

        System.out.println("Constructor test. Ok.");


//        System.out.println("JUnit version is: " + Version.id());
    }

    @Test
    public void getEmployeeFirstName_should_returnTheCorrectValue() {
        assertNotEquals(null, e3.getFirstName());
        assertEquals("Mary", e3.getFirstName());

        Employee emp = new Employee("Florence", "May", "12345", DidacticFunction.ASISTENT, 550d);
        assertNotNull(emp.getFirstName());
        assertEquals("Florence", emp.getFirstName());

        System.out.println("Get employee first name test. Ok.");
    }

    @Test
    public void getCnp_should_returnTheCorrectValue() {
        Employee emp = new Employee("James", "Oxford", "12345", DidacticFunction.LECTURER, 700d);

        assertNotNull(emp.getCnp());
        assertEquals("12345", emp.getCnp());

        System.out.println("Get cnp test. Ok.");
    }

    @Test
    public void getFirstName_throwErrorVersion() {
        try {
            e2.getFirstName();
            assert (false);
        } catch (Exception e) {                             //java.lang.NullPointerException
            System.out.println(e.toString());
            assert (true);
        }
        System.out.println("Employee e2 does not have a first name registered. Get first name - throw error. Ok.");
    }

    @Test
    @Disabled("For learning purposes")
    public void getFirstName_disabledTestVersion() {
        assertEquals("", e1.getFirstName());
        System.out.println("Disabled test. Ok.");
    }

    @Test
    public void setFirstName_assertAll() {
        e1.setFirstName("Jen");
//        e2.setFirstName("Patrick");           e2 is null - NullPointerException
        e2 = new Employee("Patrick", "sam", "123", DidacticFunction.TEACHER, 30d);
        assertEquals("Mary", e3.getFirstName());
        Employee newEmployee = new Employee("Benjamin", "Pratt", "1234", DidacticFunction.TEACHER, 30.0d);

        System.out.println("e1 first name: " + e1.getFirstName());
        System.out.println("e2 first name: " + e2.getFirstName());
        System.out.println("e3 first name: " + e3.getFirstName());
        System.out.println("new employee first name: " + newEmployee.getFirstName());

        assertAll("Employees",
                () -> assertEquals("Jen", e1.getFirstName()),
                () -> assertEquals("Patrick", e2.getFirstName()),
                () -> assertEquals("Mary", e3.getFirstName()),
                () -> assertEquals("Benjamin", newEmployee.getFirstName()));
        System.out.println("Set firstName - assertAll. Ok.");
    }


    @ParameterizedTest
    //This feature enables us to execute a single test method multiple times with different parameters.
    @ValueSource(strings = {"Bob", "Claudia"})                          //!!! Nu functioneaza decat daca se executa toate testele
    public void setFirstName_parametrizedTest(String firstName) {
        Employee emp1 = new Employee();
        emp1.setFirstName(firstName);

        assertEquals(firstName, emp1.getFirstName());
        System.out.println("Set first name (parametrized test) results: first name is " + firstName + " --> Ok.");
    }

    @Order(1)
    @Test
    public void setCnp_order1() {
        Employee emp = new Employee();
        emp.setCnp("12345");
        assertEquals("12345", emp.getCnp());
        System.out.println("Set CNP executed first. Order is correct.");
    }

    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    public void setSalary_timeout() {
        Employee emp = new Employee();
        for (int i = 0; i < 3; i++) {                   //increment i as needed
            emp.setSalary(4000d);
            System.out.print("Inside the loop #"+(i+1)+". ");
        }
        System.out.println("Outside the loop.");
    }

    @Test
    @Timeout(5)
    public void firstName_sleep() {
        Employee emp = new Employee();
        try {
            Thread.sleep(1000);
//                TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertNotNull(emp.getFirstName());
        System.out.println("Assert+timeout+sleep. Ok.");
    }

}
