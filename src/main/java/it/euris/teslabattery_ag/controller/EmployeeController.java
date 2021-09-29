package it.euris.teslabattery_ag.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.euris.teslabattery_ag.data.dto.EmployeeDto;
import it.euris.teslabattery_ag.service.EmployeeService;
@RestController
@RequestMapping("/employees")
public class EmployeeController {
  @Autowired
  EmployeeService employeeService;

  @GetMapping("/v1")
  public List<EmployeeDto> getAll() {
      return employeeService.getAll();
  }

  @GetMapping("/v1/{id}")
  public EmployeeDto getById(@PathVariable("id") Long id) {
      return employeeService.getById(id);
  }

  @PostMapping("/v1")
  public EmployeeDto insert(@RequestBody EmployeeDto dto) {
      return employeeService.add(dto);
  }

  @PutMapping("/v1")
  public EmployeeDto update(@RequestBody EmployeeDto dto) {
      return employeeService.update(dto);
  }
  
  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
      return employeeService.delete(id);
  }

}
