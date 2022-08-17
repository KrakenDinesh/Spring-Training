package com.dbs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dbs.dao.EmployeeDAOImpl;
import com.dbs.model.EmployeeVO;

public class EmployeeManagerImpl implements EmployeeManager {
	@Autowired
	EmployeeDAOImpl dao;

	@Override
	public List<EmployeeVO> getAllEmployees() {
		return dao.getAllEmployees();
	}

}
