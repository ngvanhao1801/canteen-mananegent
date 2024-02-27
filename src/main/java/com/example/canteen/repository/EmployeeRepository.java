package com.example.canteen.repository;

import com.example.canteen.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

  Employee getEmployeeById(int id);

}
