package EMS.demo.demo.service;

import EMS.demo.demo.entity.Department;
import EMS.demo.demo.exceptions.ResourceNotFountExceptions;
import EMS.demo.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFountExceptions("Department not found with id: " + id));
    }

    public Department updateDepartment(Long id, Department departmentDetails) {
        Department existingDepartment = getDepartmentById(id);
        existingDepartment.setDepartmentName(departmentDetails.getDepartmentName());
        existingDepartment.setDepartmentId(departmentDetails.getDepartmentId());
        // Update other properties if needed
        return departmentRepository.save(existingDepartment);
    }

    public void deleteDepartment(Long id) {
        Department department = getDepartmentById(id);
        departmentRepository.delete(department);
    }


}
