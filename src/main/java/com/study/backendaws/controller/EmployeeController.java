package com.study.backendaws.controller;

import com.study.backendaws.entity.Employee;
import com.study.backendaws.service.IEmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin()
public class EmployeeController {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());


  private final IEmployeeService employeeService;

  public EmployeeController(IEmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  //get all employees
  @GetMapping("/employees")
  public List<Employee> getAll() {

    logger.debug("employee_list");

    return employeeService.getAll();


  }

  //add employee
  @PostMapping("/employees")
  public Employee createEmployee(@RequestBody Employee employee) {

    logger.debug("employee_add");

    return employeeService.add(employee);
  }

  //get employee by id
  @GetMapping("/employees/{id}")
  public ResponseEntity<Employee> getById(@PathVariable Long id) {

    logger.debug("employee_getid");

    Employee employee = employeeService.findById(id);
    return ResponseEntity.ok(employee);
  }

  //update employee
  @PutMapping("/employees")
  public ResponseEntity<Employee> update(@RequestBody Employee employee) {

    logger.debug("employee_update");

    Employee employeeUpdated = employeeService.update(employee);
    return ResponseEntity.ok(employeeUpdated);
  }

  //delete employee
  @PostMapping("/employees/delete")
  public ResponseEntity<String> delete(@RequestBody Employee employee) {

    logger.debug("employee_delete ");

    employeeService.delete(employee);
    return ResponseEntity.ok("Employee deleted.");
  }

  // deleteById
  @DeleteMapping("employees/{id}")
  public ResponseEntity<Map<String,Boolean>> deleteById(@PathVariable Long id){
    logger.debug("employee_delete_byid");
    employeeService.deleteById(id);
    Map<String,Boolean> response = new HashMap<>();
    response.put("Deleted", Boolean.TRUE);
    return  ResponseEntity.ok(response);
  }

  @GetMapping("/healthz")
  public String healthz() {
    logger.debug("########################healthz");
    return "UP";
  }
}
