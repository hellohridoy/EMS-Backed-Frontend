package EMS.demo.demo.controller;

import EMS.demo.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeControlle extends JpaRepository<Employee, Long> {

}
