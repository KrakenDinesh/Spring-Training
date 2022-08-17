package com.dbs.dao;

import java.util.ArrayList;
import java.util.List;

import com.dbs.model.EmployeeVO;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public List<EmployeeVO> getAllEmployees() {
		List<EmployeeVO> employees = new ArrayList<EmployeeVO>();

		EmployeeVO dinesh = new EmployeeVO();
		dinesh.setFirstName("Dinesh");
		dinesh.setLastName("Kothapally");
		dinesh.setId(1);

		EmployeeVO luffy = new EmployeeVO();
		dinesh.setFirstName("Luffy");
		dinesh.setLastName("Monkey D");
		dinesh.setId(2);

		EmployeeVO zoro = new EmployeeVO();
		dinesh.setFirstName("Zoro");
		dinesh.setLastName("Roronoa");
		dinesh.setId(3);

		employees.add(dinesh);
		employees.add(zoro);
		employees.add(luffy);

		return employees;
	}

}
