package EMS.demo.demo.service;

import EMS.demo.demo.entity.Designation;
import EMS.demo.demo.exceptions.ResourceNotFountExceptions;
import EMS.demo.demo.repository.DesignationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesignationService {

    @Autowired
    private DesignationRepository designationRepository;

    public List<Designation> getAllDesignations() {
        return designationRepository.findAll();
    }

    public Designation createDesignation(Designation designation) {
        return designationRepository.save(designation);
    }

    public Designation getDesignationById(Long id) {
        return designationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFountExceptions("Designation not found with id: " + id));
    }

    public Designation updateDesignation(Long id, Designation designationDetails) {
        Designation existingDesignation = getDesignationById(id);
        existingDesignation.setRoleName(designationDetails.getRoleName());
        // Update other properties if needed
        return designationRepository.save(existingDesignation);
    }

    public void deleteDesignation(Long id) {
        Designation designation = getDesignationById(id);
        designationRepository.delete(designation);
    }
}

