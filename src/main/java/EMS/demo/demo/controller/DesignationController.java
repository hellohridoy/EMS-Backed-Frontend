package EMS.demo.demo.controller;
import EMS.demo.demo.entity.Designation;
import EMS.demo.demo.service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/designations")
public class DesignationController {

    @Autowired
    private DesignationService designationService;

    @GetMapping
    public List<Designation> getAllDesignations() {
        return designationService.getAllDesignations();
    }

    @PostMapping
    public ResponseEntity<Designation> createDesignation(@RequestBody Designation designation) {
        Designation createdDesignation = designationService.createDesignation(designation);
        return new ResponseEntity<>(createdDesignation, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Designation> getDesignationById(@PathVariable Long id) {
        Designation designation = designationService.getDesignationById(id);
        return ResponseEntity.ok(designation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Designation> updateDesignation(@PathVariable Long id, @RequestBody Designation designationDetails) {
        Designation updatedDesignation = designationService.updateDesignation(id, designationDetails);
        return ResponseEntity.ok(updatedDesignation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDesignation(@PathVariable Long id) {
        designationService.deleteDesignation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
