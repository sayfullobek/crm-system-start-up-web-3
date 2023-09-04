package it.ul.team.crmsystemstartup.repository;

import it.ul.team.crmsystemstartup.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
