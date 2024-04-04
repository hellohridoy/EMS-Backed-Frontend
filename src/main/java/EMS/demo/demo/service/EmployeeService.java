package EMS.demo.demo.service;
import EMS.demo.demo.entity.Employee;
import EMS.demo.demo.exceptions.ResourceNotFountExceptions;
import EMS.demo.demo.repository.EmployeeRepository;
//import com.example.demo.8080entity.Employee;
//import com.example.demo.exceptions.ResourceNotFoundException;
//import com.example.demo.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFountExceptions("Employee not found with id: " + id));
    }

    public Employee updateEmployee(long id, Employee employeeDetails) {
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFountExceptions("Employee not found with id: " + id));
        updateEmployee.setName(employeeDetails.getName());
        updateEmployee.setJobTitle(employeeDetails.getJobTitle());
        updateEmployee.setDepartment(employeeDetails.getDepartment());
        updateEmployee.setPhone(employeeDetails.getPhone());
        updateEmployee.setSalary(employeeDetails.getSalary());
        updateEmployee.setStartDate(employeeDetails.getStartDate());
        // Update other properties if needed
        return employeeRepository.save(updateEmployee);
    }

    public void deleteEmployee(long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFountExceptions("Employee not found with id: " + id));
        employeeRepository.delete(employee);
    }
}
