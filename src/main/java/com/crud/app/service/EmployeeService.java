package com.crud.app.service;

import com.crud.app.entity.Employee;
import com.crud.app.repository.EmployeeRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;


    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployee(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id){
        return employeeRepository.findById(id);
    }

    public Employee updateEmployee(Long id , Employee employee){
        Employee employee1 = getEmployeeById(employee.getId()).orElseThrow(() -> new RuntimeException("Employee not found" + employee.getId()));

        employee1.setId(employee.getId());
        employee1.setName(employee.getName());
        employee1.setEmail(employee.getEmail());
        employee1.setMobile(employee.getMobile());
        return employeeRepository.save(employee1);
    }

    public void deleteEmployee(Long id){
         employeeRepository.deleteById(id);
    }
}
