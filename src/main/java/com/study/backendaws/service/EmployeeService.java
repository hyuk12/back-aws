package com.study.backendaws.service;

import com.study.backendaws.entity.Employee;
import com.study.backendaws.repository.IEmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService{

  private final IEmployeeRepository employeeRepository;

  @Autowired
  public EmployeeService(IEmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public Employee add(Employee employee) {
    return employeeRepository.save(employee);
  }

  @Override
  public List<Employee> getAll() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee update(Employee employee) {
    return employeeRepository.save(employee);
  }

  @Override
  public void delete(Employee employee) {
    employeeRepository.delete(employee);
  }

  @Override
  public Employee findById(Long id) {
    return employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Employee not found with id:" + id));
  }

  @Override
  public void deleteById(Long id) {
    employeeRepository.deleteById(id);
  }
}
