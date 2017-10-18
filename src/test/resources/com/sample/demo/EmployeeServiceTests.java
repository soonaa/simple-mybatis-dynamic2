package com.sample.demo;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.demo.service.EmployeeService;
import com.sample.demo.vo.Criteria;
import com.sample.demo.vo.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:/META-INF/spring/app-context.xml"})
public class EmployeeServiceTests {

	@Autowired
	EmployeeService employeeService;
	
	@Test
	public void testConfig() {
		assertNotNull(employeeService);
	}
	
	@Test
	public void testGetAllEmployees() {
		List<Employee> result = employeeService.getAllEmployees();
		assertEquals(107, result.size());
	}
	
	@Test
	public void testSearchEmployees() {
		Criteria criteria = new Criteria();
		criteria.setDepts(Arrays.asList(10, 20, 30, 40, 50, 60));
		criteria.setJobs(Arrays.asList("IT_PROG", "PU_CLERK"));
		criteria.setBeginDate("2003-01-01");
		criteria.setMaxSalary(new Long(10000));
		criteria.setMinSalary(new Long(3000));
		//criteria.setOpt("name");
		//criteria.setKeyword("Pat");
		
		List<Employee> result = employeeService.searchEmployees(criteria);
		assertEquals(6, result.size());
		
	}
}
