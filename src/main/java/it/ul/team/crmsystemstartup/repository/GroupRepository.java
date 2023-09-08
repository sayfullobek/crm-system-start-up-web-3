package it.ul.team.crmsystemstartup.repository;

import it.ul.team.crmsystemstartup.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GroupRepository extends JpaRepository<Group,UUID> {

    boolean existsGroupByNameEqualsIgnoreCase(String name);
}
