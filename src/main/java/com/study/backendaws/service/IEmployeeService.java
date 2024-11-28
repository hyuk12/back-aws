package com.study.backendaws.service;

import com.study.backendaws.entity.Employee;
import java.util.List;
import org.springframework.stereotype.Service;

public interface IEmployeeService {

  Employee add(Employee employee);

  List<Employee> getAll();

  Employee update(Employee employee);

  void delete(Employee employee);

  Employee findById(Long id);

  void deleteById(Long id);
}
