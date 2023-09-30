package it.ul.team.crmsystemstartup.repository;

import it.ul.team.crmsystemstartup.entity.Group;
import it.ul.team.crmsystemstartup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface GroupRepository extends JpaRepository<Group,UUID> {

    boolean existsGroupByNameEqualsIgnoreCase(String name);
    boolean existsGroupByNameEqualsIgnoreCaseAndIdNot(String name, UUID id);

    Optional<Group> findGroupByTeacherId(UUID teacher_id);
}
