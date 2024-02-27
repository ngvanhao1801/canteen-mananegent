package com.example.canteen.controller;

import com.example.canteen.entity.Employee;
import com.example.canteen.repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

  private final EmployeeRepository employeeRepository;

  public EmployeeController(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  private boolean isEdit = false;

  private String errorMessage = "";

  @GetMapping("/add_employee")
  public String addEmployee(Model model) {
    model.addAttribute("errorMessage", errorMessage);

    return "add_employee";
  }

  @GetMapping("/employees")
  public String getAllEmployees(Model model) {
    List<Employee> employees = employeeRepository.findAll();
    model.addAttribute("employees", employees);
    return "employee_list";
  }

  @PostMapping("/save_employee")
  public String saveEmployee(@ModelAttribute Employee employee, Model model) {
    errorMessage = "";
    if (!isEdit && employeeRepository.existsById(employee.getId())) {
      isEdit = false;
      errorMessage = "Đã tồn tại id = " + employee.getId();
      model.addAttribute("employee", employee);
      return "redirect:/add_employee";
    }

    employeeRepository.save(employee);
    return "redirect:/employees";
  }

  @RequestMapping("/editEmployee/{id}")
  public String editEmployee(@PathVariable("id") int id, Model model) {
    Employee employee = employeeRepository.getEmployeeById(id);
    model.addAttribute("employee", employee);

    isEdit = true;

    return "edit_employee";
  }

  @RequestMapping("/deleteEmployee/{id}")
  public String deleteEmployee(@PathVariable("id") int id) {
    employeeRepository.deleteById(id);

    return "redirect:/employees";
  }

}
