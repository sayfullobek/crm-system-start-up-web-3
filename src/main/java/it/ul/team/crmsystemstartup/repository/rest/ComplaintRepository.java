package it.ul.team.crmsystemstartup.repository.rest;

import it.ul.team.crmsystemstartup.entity.Complaint;
import it.ul.team.crmsystemstartup.projection.CustomComplaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "list" , path = "complaint", excerptProjection = CustomComplaint.class)

public interface ComplaintRepository extends JpaRepository<Complaint , Integer> {
}
