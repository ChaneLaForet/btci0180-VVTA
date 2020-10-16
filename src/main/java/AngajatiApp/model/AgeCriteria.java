package AngajatiApp.model;

import java.util.Comparator;

public class AgeCriteria implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		int employee1Age = Integer.parseInt(o1.getCnp().substring(1,7));
		int employee2Age = Integer.parseInt(o2.getCnp().substring(1,7));
		return employee2Age - employee1Age;
	}

}
