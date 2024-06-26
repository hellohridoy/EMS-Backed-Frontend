package EMS.demo.demo.dto;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
public class DesignationDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String designationName;
}
