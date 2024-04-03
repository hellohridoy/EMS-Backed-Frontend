package EMS.demo.demo.service;
import EMS.demo.demo.entity.Skill;
import EMS.demo.demo.exceptions.ResourceNotFountExceptions;
import EMS.demo.demo.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public Skill createSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    public Skill getSkillById(Long id) {
        return skillRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFountExceptions("Skill not found with id: " + id));
    }

    public Skill updateSkill(Long id, Skill skillDetails) {
        Skill existingSkill = getSkillById(id);
        existingSkill.setSkillName(skillDetails.getSkillName());
        // Update other properties if needed
        return skillRepository.save(existingSkill);
    }

    public void deleteSkill(Long id) {
        Skill skill = getSkillById(id);
        skillRepository.delete(skill);
    }
}
