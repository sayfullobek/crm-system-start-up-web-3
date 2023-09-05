package it.ul.team.crmsystemstartup.repository.rest;

import it.ul.team.crmsystemstartup.entity.Help;
import it.ul.team.crmsystemstartup.projection.CustomHelp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="list",path = "help",excerptProjection = CustomHelp.class)
public interface HelpRepository extends JpaRepository<Help,Integer> {
}
