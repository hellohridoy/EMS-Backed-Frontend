package EMS.demo.demo.service;

import EMS.demo.demo.dto.EmployeeDto;
import EMS.demo.demo.entity.Employee;
import EMS.demo.demo.exceptions.ResourceNotFountExceptions;
import EMS.demo.demo.repository.EmployeeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Data
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();

        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        for(Employee emp : employeeList){
            EmployeeDto employeeDto = new EmployeeDto();

            employeeDto.setId(emp.getEmployeeId());
            employeeDto.setEmployeeName(emp.getName());

            employeeDtoList.add(employeeDto);
        }

        return employeeDtoList;
    }

    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();

        // Map properties from EmployeeDto to Employee
        employee.setEmployeeId(employeeDto.getId());
        employee.setName(employeeDto.getEmployeeName());
        // Map other properties as needed

        Employee savedEmployee = employeeRepository.save(employee);

        // Map the saved employee back to EmployeeDto
        EmployeeDto savedEmployeeDto = new EmployeeDto();
        savedEmployeeDto.setEmployeeName(savedEmployee.getName());
        // Map other properties from savedEmployee to savedEmployeeDto

        return savedEmployeeDto;
    }

    public EmployeeDto getEmployeeDtoById(long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setId(employee.getEmployeeId());
            employeeDto.setEmployeeName(employee.getName());
            // Map other properties from employee to employeeDto
            return employeeDto;
        } else {
            return null;
        }
    }

    public EmployeeDto updateEmployee(long id, EmployeeDto employeeDto) {
        Employee employeeToUpdate = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFountExceptions("Employee not found with id: " + id));

        // Update the employee with details from the EmployeeDto
        employeeToUpdate.setEmployeeId(employeeDto.getId());
        employeeToUpdate.setName(employeeDto.getEmployeeName());

        // Save the updated employee
        Employee updatedEmployee = employeeRepository.save(employeeToUpdate);

        // Convert the updated employee back to an EmployeeDto and return
        return convertToDto(updatedEmployee);
    }

    private EmployeeDto convertToDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getEmployeeId());
        employeeDto.setEmployeeName(employee.getName()); // Assuming employeeName is used as name
        // You can map other properties here if needed
        return employeeDto;
    }

    public void deleteEmployee(EmployeeDto employeeDto) {
        // Check if the employee with the given ID exists
        Employee employeeToDelete = employeeRepository.findById(employeeDto.getId())
                .orElseThrow(() -> new ResourceNotFountExceptions("Employee not found with id: " + employeeDto.getId()));

        // Delete the employee
        employeeRepository.delete(employeeToDelete);
    }
}
