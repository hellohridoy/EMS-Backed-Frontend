package EMS.demo.demo.entity;

import jakarta.persistence.*;


import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String name;
    private String jobTitle;
    private String department;
    private String phone;
    private double salary;
    private String startDate;
}

