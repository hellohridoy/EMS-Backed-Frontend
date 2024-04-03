package EMS.demo.demo.service;

import EMS.demo.demo.entity.Project;
import EMS.demo.demo.exceptions.ResourceNotFountExceptions;
import EMS.demo.demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFountExceptions("Project not found with id: " + id));
    }

    public Project updateProject(Long id, Project projectDetails) {
        Project existingProject = getProjectById(id);
        existingProject.setProductName(projectDetails.getProductName());
        // Update other properties if needed
        return projectRepository.save(existingProject);
    }

    public void deleteProject(Long id) {
        Project project = getProjectById(id);
        projectRepository.delete(project);
    }
}

