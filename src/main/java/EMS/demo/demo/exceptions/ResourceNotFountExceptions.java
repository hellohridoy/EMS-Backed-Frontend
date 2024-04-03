package EMS.demo.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class ResourceNotFountExceptions extends RuntimeException{

    public ResourceNotFountExceptions(String message){
        super(message);
    }
}
