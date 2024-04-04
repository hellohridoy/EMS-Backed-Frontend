package EMS.demo.demo.dto;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class ProjectDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String projectName;
}
