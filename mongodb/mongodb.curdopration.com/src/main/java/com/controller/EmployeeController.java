package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

import com.repository.EmployeeRepo;
import com.bean.Employee;
@RestController
@RequestMapping("/employee")

public class EmployeeController {
	@Autowired
    private EmployeeRepo employeeRepository;
	
	@RequestMapping(method = RequestMethod.POST)
    public Employee createBook(@RequestBody  final Employee employee) {
        return employeeRepository.save(employee);
	}
	@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
    public Optional<Employee> getBook(@PathVariable("employeeId") String employeeId) {
		return employeeRepository.findById(employeeId);
}
	 @RequestMapping(method = RequestMethod.GET)
	    public List<Employee> getEmployee() {
	        return employeeRepository.findAll();
}
	 @RequestMapping(value = "/{employeeId}", method = RequestMethod.DELETE)
	    public void deleteEmployee(@PathVariable("employeeId") Employee employeeId) {
		 employeeRepository.delete(employeeId);
	    }
}