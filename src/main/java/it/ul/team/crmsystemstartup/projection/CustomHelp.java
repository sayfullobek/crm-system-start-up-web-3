package it.ul.team.crmsystemstartup.projection;

import it.ul.team.crmsystemstartup.entity.Help;
import org.springframework.data.rest.core.config.Projection;


@Projection(name = "CustomHelp",types = Help.class)
public interface CustomHelp {
     Integer id();
     String message();
     Integer userId();
}
