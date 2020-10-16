package AngajatiApp.validator;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;

public class EmployeeValidator {
	
	public EmployeeValidator(){}

	public boolean isValid(Employee employee) {
		return isFirstNameValid(employee) 
				&& isLastNameValid(employee) 
				&& isCnpValid(employee) 
				&& isFunctionValid(employee) 
				&& isSalaryValid(employee);
	}

	private boolean isSalaryValid(Employee employee) {
		return employee.getSalary() > 0;
	}

	private boolean isFunctionValid(Employee employee) {
		return employee.getFunction().equals(DidacticFunction.ASISTENT)
				|| employee.getFunction().equals(DidacticFunction.LECTURER) 
				|| employee.getFunction().equals(DidacticFunction.TEACHER) 
				|| employee.getFunction().equals(DidacticFunction.CONFERENTIAR);
	}

	private boolean isCnpValid(Employee employee) {
		return employee.getCnp().matches("[a-z0-9]+") && (employee.getCnp().length() == 13);
	}

	private boolean isLastNameValid(Employee employee) {
		return employee.getLastName().matches("[a-zA-Z]+") && (employee.getLastName().length() > 2);
	}

	private boolean isFirstNameValid(Employee employee) {
		return employee.getFirstName().matches("[a-zA-Z]+") && (employee.getFirstName().length() > 2);
	}
	
}
