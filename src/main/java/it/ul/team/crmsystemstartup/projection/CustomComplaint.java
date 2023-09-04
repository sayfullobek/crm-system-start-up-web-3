package it.ul.team.crmsystemstartup.projection;

import it.ul.team.crmsystemstartup.entity.Complaint;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "CustomComplaint" ,types = Complaint.class)
public interface CustomComplaint {
      Integer id();
    String message();
    Integer userId();
}
