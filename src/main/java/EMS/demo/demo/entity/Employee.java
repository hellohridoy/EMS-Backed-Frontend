package EMS.demo.demo.entity;

import jakarta.persistence.*;


import jakarta.persistence.Entity;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class
Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String name;
    private String department;
    private String phone;
    private double salary;
    private String startDate;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department departmentSection;

    @Setter
    @Getter
    @Transient
    private String designation;

    @Setter
    @Getter
    @ManyToMany
    @JoinTable(
            name = "employee_project",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private Set<Project> projects = new HashSet<>();

    @Setter
    @Getter
    @ManyToMany
    @JoinTable(
            name = "employee_skill",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> skills = new HashSet<>();
}

