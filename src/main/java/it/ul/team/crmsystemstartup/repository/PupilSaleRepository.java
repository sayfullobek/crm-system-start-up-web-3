package it.ul.team.crmsystemstartup.repository;

import it.ul.team.crmsystemstartup.entity.PupilSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface PupilSaleRepository extends JpaRepository<PupilSale , Integer> {

}
